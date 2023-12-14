package homeWork22.services;

import homeWork22.dto.CreateUserDTO;
import io.restassured.response.Response;

public class UserService extends BaseService {

    protected static final String userPath = "/users/";

    public Response getSingleUser(int userId) {
        return setRequestSpec()
                .given()
                .when()
                .get(userPath + userId);
    }

    public Response createUser(CreateUserDTO createUser) {
        return setRequestSpec()
                .given()
                .body(createUser)
                .when()
                .post(userPath);
    }

    public Response deleteUser(int userId) {
        return setRequestSpec()
                .given()
                .when()
                .delete(userPath + userId);
    }
}

