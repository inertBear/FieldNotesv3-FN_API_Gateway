package com.devhunter;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class LoginEndpointTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().get("/gateway/login?username=username&password=password")
                .then()
                .statusCode(200)
                .body(is("Login Failed"));
    }
}