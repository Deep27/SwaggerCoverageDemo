package io.deep27soft.api_test_coverage;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Utils {

    public static ValidatableResponse get(String url) {
        return RestAssured.given()
                .baseUri("http://localhost")
                .port(8080)
                .get(url)
                .then()
                .statusCode(200);
    }
}
