import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

public class Authorization {
    @Test
    @Epic(value = "Authorization Endpoints")
    @Story("Authorization")
    @Feature("LogIn Positive")
    @Description("LogIn Storage Positive")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("LogIn Storage Positive")
    @Step ("Успешная авторизация пользователя.")
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

        try {
            response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @Epic(value = "Authorization Endpoints")
    @Story("Authorization")
    @Feature("LogIn Negative")
    @DisplayName("LogIn Storage Negative")
    @Description("LogIn Storage Negative")
    @Severity(SeverityLevel.NORMAL)
    @Step ("Неуспешная авторизация пользователя.")
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
        }  finally {
            TestStorage.getBody(response);
        }
    }
    @Test
    @Epic(value = "Authorization Endpoints")
    @Story("Authorization")
    @Feature("LogOut")
    @DisplayName("LogOut Storage")
    @Description("LogOut Storage Positive")
    @Severity(SeverityLevel.NORMAL)
    @Step ("Успешная деавторизация пользователя.")
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
        }   finally {
            TestStorage.getBody(response);
        }
    }
}
