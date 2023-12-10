package homeWork22;

import homeWork22.dto.CreateUserDTO;
import homeWork22.dto.CreateUserResponseDTO;
import homeWork22.dto.GetSingleUserResponseDTO;
import homeWork22.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserTests {

    private final UserService userService = new UserService();
    private final int createdUserId = 2;

    @Test
    public void getSingleUserNotFound() {
        userService.getSingleUser(TestData.randomId())
                .then()
                .statusCode(HttpStatusCode.NOT_FOUND.getCode());
    }

    @Test
    public void createUser() {
        CreateUserDTO expectedUser = TestData.createDefaultUser();

        Response response = userService.createUser(expectedUser);

        CreateUserResponseDTO actualUserDto = response.then().statusCode(HttpStatusCode.CREATED.getCode())
                .extract().as(CreateUserResponseDTO.class);

        assertEquals(actualUserDto.getName(), expectedUser.getName());
        assertEquals(actualUserDto.getJob(), expectedUser.getJob());
        assertNotNull(actualUserDto.getId());
        assertTrue(TestData.isTimeFresh(actualUserDto.getCreatedAt()));
    }

    @Test
    public void getSingleUser() {
        Response response = userService.getSingleUser(createdUserId);

        GetSingleUserResponseDTO actualUserDto = response.then().statusCode(HttpStatusCode.OK.getCode())
                .extract().as(GetSingleUserResponseDTO.class);

        assertEquals(actualUserDto.getGetSingleUserData().getId(), createdUserId);
        assertNotNull(actualUserDto.getGetSingleUserData().getFirstName());
    }

    @Test(dependsOnMethods = "getSingleUser")
    public void deleteUser() {
        userService.deleteUser(createdUserId)
                .then()
                .statusCode(HttpStatusCode.NO_CONTENT.getCode());
    }
}

