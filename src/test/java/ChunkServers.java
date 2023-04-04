import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChunkServers {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }


    @Test
    @DisplayName("Get chunks server list")
    @Epic(value = "Cluster")
    @Story("Chunk Servers")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#f813f502-1eab-4205-88b3-837009495ad4")
    @Feature("Get chunks server list")
    @Description("Get chunks server list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список серверов фрагментов кластера.")
    public void getChunksServerList() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
//Params: optional query parameters:
// `params={"fields":["id","status","host_info","space"]}`.
// If provided, request return only listed fields for each cs.
                .when()
                .get("/api/v2/"+ TestStorage.cluster_id+"/css/");
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
    @DisplayName("Start chunks server")
    @Epic(value = "Cluster")
    @Story("Chunk Servers")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b68962f3-ddc0-4aa6-b8ea-9f8b4cfe31f4")
    @Feature("Start chunks server")
    @Description("Start chunks server")
    @Severity(SeverityLevel.MINOR)
    @Step ("Запустить сервер фрагментов кластера.")
    public void startChunksServer() {
        String requestBody = "{\n" +
                "    \"node_id\":\"1\",\n" +
                "    \"path\":\"https://192.168.12.47:8888/\",\n" +
                "    \"journal_path\" : \"https://192.168.12.47:8888/\",\n" +
                "    \"journal_data_size\":\"1073741824\",\n" +
                "    \"journal_metadata_size\": \"1073741824\"\n" +
                "}";
/*
`journal_*` params is optional.
 If `journal_path` provided, cs will be created with journal located on given path.
 If `journal_data_size` and `journal_metadata_size` provided, journal size for data and metadata will be set.
 If `journal_metadata_size` is provided, `journal_data_size` must be provided too.
*/
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/css/");
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
    @DisplayName("Get chunks server work info")
    @Epic(value = "Cluster")
    @Story("Chunk Servers")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b62f5922-a59a-412d-8438-ae0bc4b1a72c")
    @Feature("Get chunks server work info")
    @Description("Get chunks server work info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о работе сервера фрагментов кластера.")
    public void getChunksServerInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/css/1/");
/*
Params: optional query parameters:
`params={"fields":["id","status","host_info","space"]}`.
If provided, request return only listed fields for each cs.
*/
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
    @Disabled
    @DisplayName("Delete chunks server")
    @Epic(value = "Cluster")
    @Story("Chunk Servers")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a37faa9d-6853-4a18-957a-aece186909d1")
    @Feature("Delete chunks server")
    @Description("Delete chunks server")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить сервер фрагментов кластера.")
    public void deleteChunksServer() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/"+TestStorage.cluster_id+"/css/1/");
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
