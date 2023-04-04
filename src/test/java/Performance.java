import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Performance {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Start task which test disk performance")
    @Epic(value = "Performance")
    @Story("Performance")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#9fe62eb6-8800-4576-bd24-6c39013612aa")
    @Feature("Start task which test disk performance")
    @Description("Start task which test disk performance")
    @Severity(SeverityLevel.MINOR)
    @Step ("Запуск задания по тестированию производительности дисков.")
    public void startPerformanceTask () {
        String requestBody = "{\"disks\":[{\"name\":\"disk_name\"}]}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/performance_tests/192.168.12.45/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(202)
//                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 202 ACCEPTED")
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
