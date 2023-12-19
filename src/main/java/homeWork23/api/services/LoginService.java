package homeWork23.api.services;

import homeWork23.api.dto.UserDTO;
import io.restassured.response.Response;

public class LoginService extends BaseService {

    public static Response loginUser(UserDTO loginRequest) {
        return setRequestSpec()
                .given()
                .body(loginRequest).post("/Login");
    }
}
