package homeWork23;

import homeWork23.api.dto.*;
import homeWork23.api.services.CheckOutService;
import homeWork23.api.services.LoginService;
import homeWork23.api.services.ShoppingCartService;
import homeWork23.api.services.UserService;
import homeWork23.utils.HttpStatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static homeWork23.api.services.ShoppingCartService.containsBookIdInCart;
import static homeWork23.utils.DataGenerator.*;
import static org.testng.Assert.*;


public class BookCartApiTests {

    final Integer bookId = 2;
    UserDTO user;
    String token;
    Integer userId;
    BookDTO targetBook;


    @Test
    public void createUserValidData() {

        user = UserDTO.builder()
                .userId(0)
                .firstName(randomFirstName())
                .lastName(randomLastName())
                .username(randomUserName())
                .password(randomPassword())
                .gender(randomGender())
                .userTypeId(randomIntId())
                .build();

        Response response = UserService.createUser(user);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test
    public void createUserEmptyRequiredValues() {

        UserDTO user = UserDTO.builder()
                .userId(0)
                .firstName("")
                .lastName("")
                .username("")
                .password("")
                .gender("")
                .userTypeId(0)
                .build();

        Response response = UserService.createUser(user);
        assertEquals(response.getStatusCode(), HttpStatusCode.BAD_REQUEST.getCode());
    }

    @Test(dependsOnMethods = "createUserValidData")
    public void loginValidData() {

        Response response = LoginService.loginUser(user);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());

        LoginResponseDTO loginResponse = response.as(LoginResponseDTO.class);
        assertEquals(loginResponse.getUserDTO().getUsername(), user.getUsername());

        token = loginResponse.getToken();
        assertNotNull(token);

        userId = loginResponse.getUserDTO().getUserId();
        assertNotNull(userId);
    }

    @Test
    public void loginUnexistingUser() {

        UserDTO user = UserDTO.builder()
                .userId(randomIntId())
                .firstName(randomFirstName())
                .lastName(randomLastName())
                .username(randomUserName())
                .password(randomPassword())
                .gender(randomGender())
                .userTypeId(randomIntId())
                .build();

        Response response = LoginService.loginUser(user);
        assertEquals(HttpStatusCode.UNAUTHORIZED.getCode(), response.getStatusCode());
    }

    @Test(dependsOnMethods = "loginValidData")
    public void addToCartValidData() {
        Response response = ShoppingCartService.addToCart(userId, bookId);
        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());

        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("1"));
    }

    @Test(dependsOnMethods = "loginValidData")
    public void addToCartUnexistingUser() {
        Response response = ShoppingCartService.addToCart(randomIntId(), bookId);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }


    @Test(dependsOnMethods = "addToCartValidData")
    public void getCart() {

        Response response = ShoppingCartService.getCart(userId);
        assertEquals(HttpStatusCode.OK.getCode(), response.getStatusCode());
        List<ShoppingCartResponseDTO> cart = response.jsonPath().getList("", ShoppingCartResponseDTO.class);

        assertNotNull(cart);
        assertTrue(containsBookIdInCart(cart, bookId));

        targetBook = ShoppingCartService.findBookByBookId(cart, bookId);
    }

    @Test
    public void getCartBadUserId() {
        Response response = ShoppingCartService.getCart(0);

        assertEquals(response.getStatusCode(), HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test(dependsOnMethods = {"addToCartValidData", "getCart"})
    public void checkOut() {

        OrderDetailsDTO orderDetail = OrderDetailsDTO.builder()
                .book(targetBook)
                .quantity(1)
                .build();

        CheckOutDTO checkOut = CheckOutDTO.builder()
                .orderId(randomStringId())
                .orderDetails(Collections.singletonList(orderDetail))
                .cartTotal(1)
                .orderDate(currentFormattedTime())
                .build();

        Response response = CheckOutService.checkOut(userId, token, checkOut);

        assertEquals(response.getStatusCode(), HttpStatusCode.OK.getCode());
    }

    @Test(dependsOnMethods = {"addToCartValidData", "getCart"})
    public void checkOutBadToken() {

        OrderDetailsDTO orderDetail = OrderDetailsDTO.builder()
                .book(targetBook)
                .quantity(1)
                .build();

        CheckOutDTO checkOut = CheckOutDTO.builder()
                .orderId(randomStringId())
                .orderDetails(Collections.singletonList(orderDetail))
                .cartTotal(1)
                .orderDate(currentFormattedTime())
                .build();

        Response response = CheckOutService.checkOut(userId, "", checkOut);

        assertEquals(response.getStatusCode(), HttpStatusCode.UNAUTHORIZED.getCode());
    }
}

