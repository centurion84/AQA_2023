package homeWork23.api.services;

import io.restassured.response.Response;

public class BookService extends BaseService {

    public static Response getBooks() {
        return setRequestSpec()
                .given()
                .get("/Book");
    }
}

