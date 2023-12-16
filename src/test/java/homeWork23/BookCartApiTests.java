package homeWork23;

import homeWork23.api.dto.*;
import homeWork23.api.services.CheckOutService;
import homeWork23.api.services.LoginService;
import homeWork23.api.services.ShoppingCartService;
import homeWork23.api.services.UserService;
import homeWork23.utils.HttpStatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static homeWork23.api.services.LoginService.getCreatedUserId;
import static homeWork23.api.services.LoginService.getCreatedUserToken;
import static homeWork23.api.services.ShoppingCartService.containsBookIdInCart;
import static homeWork23.api.services.ShoppingCartService.getTargetBookObject;
import static homeWork23.utils.DataGenerator.randomIntId;
import static homeWork23.utils.TestData.*;
import static org.testng.Assert.*;


public class BookCartApiTests {

    final Integer bookId = 2;

    @Test
    public void createUserValidData() {
        Response response = UserService.createUser(randomUserData());
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test
    public void createUserEmptyRequiredValues() {

        UserDTO user = emptyUserData();

        Response response = UserService.createUser(user);
        assertEquals(response.getStatusCode(), HttpStatusCode.BAD_REQUEST.getCode());
    }

    @Test
    public void loginValidData() {

        UserDTO user = randomUserData();
        UserService.createUser(user);

        Response response = LoginService.loginUser(user);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());

        LoginResponseDTO loginResponse = response.as(LoginResponseDTO.class);
        assertEquals(loginResponse.getUserDTO().getUsername(), user.getUsername());
        assertNotNull(loginResponse.getToken());
    }

    @Test
    public void loginUnexistingUser() {

        UserDTO user = randomUserData();

        Response response = LoginService.loginUser(user);
        assertEquals(HttpStatusCode.UNAUTHORIZED.getCode(), response.getStatusCode());
    }

    @Test
    public void addToCartValidData() {

        UserDTO user = randomUserData();
        UserService.createUser(user);

        Integer userId = getCreatedUserId(LoginService.loginUser(user));

        Response response = ShoppingCartService.addToCart(userId, bookId);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("1"));
    }

    @Test
    public void addToCartUnexistingUser() {
        Response response = ShoppingCartService.addToCart(randomIntId(), bookId);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }


    @Test
    public void getCart() {

        UserDTO user = randomUserData();
        UserService.createUser(user);

        Integer userId = getCreatedUserId(LoginService.loginUser(user));
        ShoppingCartService.addToCart(userId, bookId);

        Response response = ShoppingCartService.getCart(userId);
        assertEquals(HttpStatusCode.OK.getCode(), response.getStatusCode());
        List<ShoppingCartResponseDTO> cart = response.jsonPath().getList("", ShoppingCartResponseDTO.class);

        assertNotNull(cart);
        assertTrue(containsBookIdInCart(cart, bookId));
    }

    @Test
    public void getCartBadUserId() {
        Response response = ShoppingCartService.getCart(0);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test
    public void checkOut() {

        UserDTO user = randomUserData();
        UserService.createUser(user);

        Integer userId = getCreatedUserId(LoginService.loginUser(user));
        String token = getCreatedUserToken(LoginService.loginUser(user));

        ShoppingCartService.addToCart(userId, bookId);
        BookDTO targetBook = getTargetBookObject(userId, bookId);

        CheckOutDTO checkOut = checkoutBody(targetBook);
        Response response = CheckOutService.checkOut(userId, token, checkOut);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test
    public void checkOutEmptyToken() {

        UserDTO user = randomUserData();
        UserService.createUser(user);

        int userId = getCreatedUserId(LoginService.loginUser(user));
        ShoppingCartService.addToCart(userId, bookId);

        BookDTO targetBook = getTargetBookObject(userId, bookId);

        CheckOutDTO checkOut = checkoutBody(targetBook);
        Response response = CheckOutService.checkOut(userId, "", checkOut);

        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }
}

