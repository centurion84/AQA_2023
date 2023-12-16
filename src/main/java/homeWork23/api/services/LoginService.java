package homeWork23.api.services;

import homeWork23.api.dto.LoginResponseDTO;
import homeWork23.api.dto.UserDTO;
import io.restassured.response.Response;

public class LoginService extends BaseService {

    public static Response loginUser(UserDTO loginRequest) {
        return setRequestSpec()
                .given()
                .body(loginRequest).post("/Login");
    }

    public static Integer getCreatedUserId(Response response) {
        LoginResponseDTO loginResponse = response.as(LoginResponseDTO.class);
        return loginResponse.getUserDTO().getUserId();
    }

    public static String getCreatedUserToken(Response response) {
        LoginResponseDTO loginResponse = response.as(LoginResponseDTO.class);
        return loginResponse.getToken();
    }
}
