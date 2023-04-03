package org.example;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.Suite;

//@Suite.SuiteClasses(Authorization.class)
public class Authorization {
    @Test
    @Step
    @Epic(value = "Authorization Endpoints")
    @Story("Authorization")
    @Feature("LogIn Positive")
    @Description("LogIn Storage Positive")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("LogIn Storage Positive")
    public void logInP() {
        RestAssured.baseURI = TestStorage.endpoint;
        JSONObject requestBody = new JSONObject()
                .put("password", "1234")
                .put("username", "root");
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/api/v2/login/");

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test
    @Step
    @Epic(value = "Authorization Endpoints")
    @Story("Authorization")
    @Feature("LogIn Negative")
    @DisplayName("LogIn Storage Negative")
    @Description("LogIn Storage Negative")
    @Severity(SeverityLevel.NORMAL)
    public void logInN() {
        RestAssured.baseURI = TestStorage.endpoint;
        JSONObject requestBody = new JSONObject()
                .put("password", "wrong password")
                .put("username", "user");
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/api/v2/login/");

        try {
            response.then()
                    .assertThat()
                    .statusCode(401)
                    .contentType("application/json")
//                    .log().body()
                    .statusLine("HTTP/1.1 401 UNAUTHORIZED");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Step
    @Epic(value = "Authorization Endpoints")
    @Story("Authorization")
    @Feature("LogOut")
    @DisplayName("LogOut Storage")
    @Description("LogOut Storage Positive")
    @Severity(SeverityLevel.NORMAL)
    public void logOut() {
        RestAssured.baseURI = TestStorage.endpoint;
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .when()
                .post("/api/v2/logout/");

        try {
            response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
