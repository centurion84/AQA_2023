package homeWork22.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    public static final String BASE_URL = "https://reqres.in/api";

    private RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    protected RequestSpecification setRequestSpec() {
        return RestAssured.given().spec(buildRequestSpec());
    }
}
