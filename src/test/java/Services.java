import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Services {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get services info")
    @Epic(value = "Cluster Services")
    @Story("Services")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b9083ff3-0c86-4fd1-b01f-0937b1f19571")
    @Feature("Storage Services info")
    @Description("Get Storage services info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список кластерных сервисов Р-Хранилища.")
    public void getServicesInfo () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+ TestStorage.cluster_id+"/services/059ac5a5-0724-4d66-a09b-a9163ba00859");
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

}
