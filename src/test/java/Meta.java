import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Meta {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Provides info about all backend server endpoints")
    @Epic(value = "Meta")
    @Story("Meta")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#32efb505-60d9-47f8-99d4-5af821ecdc5b")
    @Feature("Provides info about all backend server endpoints")
    @Description("Provides info about all backend server endpoints")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о серверах метаданных.")
    public void getMetaInfo () {
         Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/meta/");
        try {
                    response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
//            System.out.println(response.statusCode() + "\n" +response.getBody().jsonPath().getString("message"));
//            System.out.println(response.getBody().prettyPrint());
            TestStorage.getBody(response);
        }
    }


}
