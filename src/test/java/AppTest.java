import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runners.Suite;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//@Suite.SuiteClasses(AppTest.class)
public class AppTest {

    @Test
    @DisplayName("Assert True Test")
    @Step
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
    @Step
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
    @Step
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


    @Test
    @Step
    @Epic(value = "Authorization1 Endpoints")
    @Story("Authorization1")
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
}
