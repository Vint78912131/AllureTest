import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Clasters {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }
    @Test
    @DisplayName("Register new Cluster")
    @Epic(value = "Cluster Clusters")
    @Story("Clusters")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#fd5eb729-40e2-494d-885c-d5de31c697dc")
    @Feature("Register new Cluster")
    @Description("Register new Cluster")
    @Severity(SeverityLevel.MINOR)
    @Disabled
    @Step ("Зарегистрировать новый кластер.")
    public void setNewCluster() {
        String requestBody ="{" +
                "\"cluster_name\":\"newCluster\",\n" +
                "\"host\":\"192.168.12.50:8888\",\n" +
                "\"node_id\":\"059ac5a5-0724-4d66-a09b-a9163ba00859\",\n" +
                "\"password\":\"1234\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/clusters/");
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
    @DisplayName("Get clusters info")
    @Epic(value = "Cluster Clusters")
    @Story("Clusters")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#97691d2c-6b16-470a-bb6a-158692e63423")
    @Feature("Get Cluster info")
    @Description("Get Cluster info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о кластере.")
    public void getClustersInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/clusters/");
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
    @DisplayName("Get cluster password by cluster_id")
    @Epic(value = "Cluster Clusters")
    @Story("Clusters")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#d7214eb2-eaa9-4dbc-b484-4ad9caf38d3a")
    @Feature("Get cluster password by cluster_id")
    @Description("Get cluster password by cluster_id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить пароль кластера по cluster_id.")
    public void getClusterPassword() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/clusters/"+TestStorage.cluster_id+"/password/");

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
    @DisplayName("Get cluster info by cluster_id")
    @Epic(value = "Cluster Cluster")
    @Story("Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#d056daed-27f9-40f0-aebf-0f9b8da0c5aa")
    @Feature("Get cluster info by cluster_id")
    @Description("Get cluster info by cluster_id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о кластере по cluster_id.")
    public void getClusterInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/clusters/"+TestStorage.cluster_id+"/");

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
    @DisplayName("Delete cluster by cluster_id")
    @Epic(value = "Cluster Cluster")
    @Story("Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#d374fa87-5c23-4ea4-b749-4a39da7d365a")
    @Feature("Delete cluster by cluster_id")
    @Description("Delete cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить кластер по cluster_id.")
    @Disabled
    public void deleteCluster() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/clusters/"+TestStorage.cluster_id+"/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(204)
                    .statusLine("HTTP/1.1 204 NO CONTENT");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        TestStorage.getBody(response);
    }

}
