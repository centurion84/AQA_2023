package homeWork23.api.services;

import io.restassured.response.Response;

public class CartService extends BaseService {

    public static Response addToCart(Integer userId, Integer bookId) {
        return setRequestSpec()
                .given().pathParam("getCreatedUserId", String.valueOf(userId)).pathParam("bookId", bookId)
                .post("/ShoppingCart/AddToCart/{getCreatedUserId}/{bookId}");
    }

    public static Response getCart(Integer userId) {
        return setRequestSpec()
                .given().pathParam("getCreatedUserId", String.valueOf(userId)).get("/ShoppingCart/{getCreatedUserId}");
    }
}