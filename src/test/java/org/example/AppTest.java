package org.example;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    @DisplayName("Assert True Test")
//    @Step
    @Epic("Testing")
    @Story("Logical testing")
    @Feature("Positive")
    @Description("Assert True Test")
    @Severity(SeverityLevel.MINOR)
    public void testTrue()
    {
        assertTrue( true );
    }

    @Test
    @DisplayName("Assert False Test")
//    @Step
    @Epic("Testing")
    @Story("Logical testing")
    @Feature("Positive")
    @Description("Assert False Test")
    @Severity(SeverityLevel.MINOR)
    public void testFalse()
    {
        assertFalse( false );
    }

    @Test
    @DisplayName("Assert RestApi Get Test")
//    @Step
    @Epic("Testing")
    @Story("RestApi testing")
    @Feature("Positive")
    @Description("Assert RestApi Get Test")
    @Severity(SeverityLevel.MINOR)
    public void testRestGet () {
        RestAssured.baseURI = "https://reqres.in/";
        String user_id = "1";

        Response response = RestAssured
                .given()
                .when()
                .get("/api/users/" + user_id);

        try {
            response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println(response.prettyPrint());
        }
    }



}
