package homeWork23.api.services;

import homeWork23.api.dto.CheckOutDTO;
import io.restassured.response.Response;

public class CheckOutService extends BaseService {

    public static Response checkOut(Integer userId, String token, CheckOutDTO checkOut) {
        return setRequestSpec()
                .given()
                .header("Authorization", "Bearer " + token)
                .pathParam("userId", userId)
                .body(checkOut)
                .post("/CheckOut/{userId}");
    }
}

