package homeWork23;

import homeWork23.api.dto.*;
import homeWork23.api.services.CartService;
import homeWork23.api.services.CheckOutService;
import homeWork23.api.services.LoginService;
import homeWork23.api.services.UserService;
import homeWork23.listeners.TestListener;
import homeWork23.utils.HttpStatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static homeWork23.api.services.helpers.BookServiceHelper.getBookId;
import static homeWork23.api.services.helpers.CartServiceHelper.getTargetBookObject;
import static homeWork23.utils.DataGenerator.randomIntId;
import static homeWork23.utils.TestData.*;
import static org.testng.Assert.*;

@Listeners(TestListener.class)
public class BookCartApiTests {

    @Test
    public void createUserValidData() {
        Response response = UserService.createUser(randomUserData());
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test
    public void createUserEmptyRequiredValues() {

        UserDTO userDTO = emptyUserData();

        Response response = UserService.createUser(userDTO);
        assertEquals(response.getStatusCode(), HttpStatusCode.BAD_REQUEST.getCode());
    }

    @Test
    public void loginValidData() {

        UserDTO userDTO = randomUserData();
        UserService.createUser(userDTO);

        Response response = LoginService.loginUser(userDTO);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());

        LoginResponseDTO loginResponse = response.as(LoginResponseDTO.class);
        assertEquals(loginResponse.getUserDTO().getUsername(), userDTO.getUsername());
        assertNotNull(loginResponse.getToken());
    }

    @Test
    public void loginUnexistingUser() {

        UserDTO userDTO = randomUserData();

        Response response = LoginService.loginUser(userDTO);
        assertEquals(HttpStatusCode.UNAUTHORIZED.getCode(), response.getStatusCode());
    }

    @Test
    public void addToCartValidData() {

        UserDTO userDTO = randomUserData();
        UserService.createUser(userDTO);

        LoginResponseDTO loginResponse = LoginService.loginUser(userDTO).as(LoginResponseDTO.class);

        Response response = CartService.addToCart(loginResponse.getUserDTO().getUserId(), getBookId());
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("1"));
    }

    @Test
    public void addToCartUnexistingUser() {

        Integer bookId = getBookId();

        Response response = CartService.addToCart(randomIntId(), bookId);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }


    @Test
    public void getCart() {

        UserDTO userDTO = randomUserData();
        UserService.createUser(userDTO);

        LoginResponseDTO loginResponse = LoginService.loginUser(userDTO).as(LoginResponseDTO.class);

        Integer bookId = getBookId();
        CartService.addToCart(loginResponse.getUserDTO().getUserId(), bookId);
        BookDTO targetBook = getTargetBookObject(loginResponse.getUserDTO().getUserId(), bookId);

        Response response = CartService.getCart(loginResponse.getUserDTO().getUserId());
        assertEquals(HttpStatusCode.OK.getCode(), response.getStatusCode());

        List<CartResponseDTO> booksInCart = response.jsonPath().getList("", CartResponseDTO.class);
        assertEquals(booksInCart.size(), 1);
        assertEquals(booksInCart.get(0).getBook(), targetBook);
    }

    @Test
    public void getCartBadUserId() {
        Response response = CartService.getCart(0);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test
    public void checkOut() {

        UserDTO userDTO = randomUserData();
        UserService.createUser(userDTO);

        LoginResponseDTO loginResponse = LoginService.loginUser(userDTO).as(LoginResponseDTO.class);

        Integer bookId = getBookId();
        CartService.addToCart(loginResponse.getUserDTO().getUserId(), bookId);
        BookDTO targetBook = getTargetBookObject(loginResponse.getUserDTO().getUserId(), bookId);

        CheckOutDTO checkOut = checkoutBody(targetBook);
        Response response = CheckOutService.checkOut(loginResponse.getUserDTO().getUserId(), loginResponse.getToken(), checkOut);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test
    public void checkOutEmptyToken() {

        UserDTO userDTO = randomUserData();
        UserService.createUser(userDTO);

        LoginResponseDTO loginResponse = LoginService.loginUser(userDTO).as(LoginResponseDTO.class);

        Integer bookId = getBookId();
        CartService.addToCart(loginResponse.getUserDTO().getUserId(), bookId);
        BookDTO targetBook = getTargetBookObject(loginResponse.getUserDTO().getUserId(), bookId);

        CheckOutDTO checkOut = checkoutBody(targetBook);
        Response response = CheckOutService.checkOut(loginResponse.getUserDTO().getUserId(), "", checkOut);
        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }
}

