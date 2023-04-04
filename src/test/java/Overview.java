import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Overview {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get list of all clusters with state")
    @Epic(value = "Overview")
    @Story("Overview")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#2df3576d-9c6d-4ca2-9972-4bf32c5cdc41")
    @Feature("Get list of all clusters")
    @Description("Get list of all clusters with state")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о всех кластерах с состоянием.")
    public void getOverview() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/overview/");
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
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Cluster overview details")
    @Epic(value = "Overview")
    @Story("Overview")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#1063bd25-376d-4e79-b1d8-65ad290c94e6")
    @Feature("Cluster overview details info")
    @Description("Get Cluster overview details")
    @Severity(SeverityLevel.MINOR)
    @Step ("Обзор кластера.")
    public void getOverviewById() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/overview/" + TestStorage.cluster_id);
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
            TestStorage.getBody(response);
        }
    }


}
