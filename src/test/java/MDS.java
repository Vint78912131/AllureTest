import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MDS {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Provides info about all mds servers in cluster")
    @Epic(value = "MDS")
    @Story("MDS MDSS")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#0cbf1b51-0945-4c33-ae21-93607d73e2c5")
    @Feature("Provides info about all mds servers in cluster")
    @Description("Provides info about all mds servers in cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о серверах матаданных кластера.")
    public void getMDSSInfo () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/mdss/");
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
    @DisplayName("Start task which create new mds")
    @Epic(value = "MDS")
    @Story("MDS MDSS")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#0cbf1b51-0945-4c33-ae21-93607d73e2c5")
    @Feature("Start task which create new mds")
    @Description("Start task which create new mds")
    @Severity(SeverityLevel.MINOR)
    @Step ("Запуск задачи на создание нового сервера метаданных.")
    public void setMDSS () {
        /*
Request description
port and password is optional.
If init_cluster set in true, password must be set.
*/
        String requestBody = "{" +
                "\"path\":\"s3.RP.ru\"," +
                "\"node_id\":849e6c83-1b10-489f-855a-dc2fa80271e2," +
                "\"init_cluster\":true," +
                "\"port\":8080," +
                "\"password\":\"new_pass\"" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/mdss/");
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
    @DisplayName("Provides info about single mds")
    @Epic(value = "MDS")
    @Story("MDS MDS")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b711d9b7-c0e6-49bf-aafc-1071d2e8f719")
    @Feature("Provides info about single mds")
    @Description("Provides info about single mds")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о сервере метаданных по id.")
    public void getMDSInfo () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/mdss/1/");
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
//            System.out.println(response.statusCode() + "\n" +response.getBody().jsonPath().getString("message"));
            System.out.println(response.getBody().prettyPrint());
        }
    }

    @Test
    @DisplayName("Remove mds from cluster")
    @Epic(value = "MDS")
    @Story("MDS MDS")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#834eab1f-2dcb-490c-bcd3-46e05be0b061")
    @Feature("Remove mds from cluster")
    @Description("Remove mds from cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить сервер метаданных из кластера.")
    @Disabled
    public void deleteMDS () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/" + TestStorage.cluster_id + "/mdss/1/");
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
