import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SoftwareUpdate {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get Software update status")
    @Epic(value = "Software update")
    @Story("Software update")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#68b2fcd0-0635-4aae-9684-5f9133fc9109")
    @Feature("Get Software update status")
    @Description("Get Software update status")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить статус обновления ПО.")
    public void getSoftUpdateStatus() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/" + TestStorage.cluster_id + "/software_updates/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(404)
//                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Start Software update")
    @Epic(value = "Software update")
    @Story("Software update")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#c2503375-a833-48a9-bcaa-000a591152e7")
    @Feature("Start Software update")
    @Description("Start Software update")
    @Severity(SeverityLevel.MINOR)
    @Step ("Начать обновление ПО.")
    public void startSoftUpdate() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/" + TestStorage.cluster_id + "/software_updates/start/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(404)
//                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }
    @Test
    @DisplayName("Check Software update status")
    @Epic(value = "Software update")
    @Story("Software update")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#019f5ae2-c03a-4171-968b-dd0900cb02e2")
    @Feature("Check Software update status")
    @Description("Check Software update status")
    @Severity(SeverityLevel.MINOR)
    @Step ("Проверить статус обновления ПО.")
    public void checkSoftUpdate() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/" + TestStorage.cluster_id + "/software_updates/check/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(404)
//                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }



}
