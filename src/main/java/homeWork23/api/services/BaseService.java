package homeWork23.api.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    public static final String BASE_URL = "https://bookcart.azurewebsites.net/api";

    private static RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType("application/json")
                .setAccept("application/json")
                .addFilter(new AllureRestAssured())
                .build();
    }

    protected static RequestSpecification setRequestSpec() {
        return RestAssured.given().spec(buildRequestSpec());
    }

}
