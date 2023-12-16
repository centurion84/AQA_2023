package homeWork23.api.services;

import homeWork23.api.dto.UserDTO;
import io.restassured.response.Response;

public class UserService extends BaseService {

    public static Response createUser(UserDTO user) {
        return setRequestSpec()
                .given()
                .body(user)
                .post("/User");
    }
}
