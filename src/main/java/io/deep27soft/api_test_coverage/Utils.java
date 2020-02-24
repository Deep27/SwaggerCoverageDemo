package io.deep27soft.api_test_coverage;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Utils {

    private static RequestSpecification prepareQuery() {
        return RestAssured.given()
                .baseUri("http://localhost")
                .port(8080);
    }

    private static RequestSpecification preparePostQuery(Object body) {
        return prepareQuery()
                .body(body);
    }

    public static ValidatableResponse get(String url) {
        return prepareQuery()
                .get(url)
                .then()
                .statusCode(200);
    }

    public static ValidatableResponse get(String url, Map<String, ?> params) {
        return prepareQuery()
                .params(params)
                .get(url)
                .then()
                .statusCode(200);
    }

    public static ValidatableResponse post(String url, Object body) {
        return preparePostQuery(body)
                .post()
                .then()
                .statusCode(200);
    }
}
