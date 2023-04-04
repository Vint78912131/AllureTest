import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Nodes {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get Node disks info")
    @Epic(value = "Nodes Disks")
    @Story("Disks")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#1e5e785f-e77e-433b-afb4-93d3425c601f")
    @Feature("Get Node disks info by ip")
    @Description("Get Node disks info by ip")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о дисках сервера.")
    public void getNodeDisksInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/disks/192.168.12.45/");
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
    @DisplayName("Get Nodes list")
    @Epic(value = "Nodes Nodes")
    @Story("Nodes")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#6ddec5dd-5cb8-4b70-ae58-298c9c0049a3")
    @Feature("Get Nodes list by cluster_id")
    @Description("Get Nodes list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список серверов кластера.")
    public void getNodesList() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("cluster",TestStorage.cluster_id)
//params
//{"cluster": [clusterId1, clusterId2, ..., clusterIdN, null]}
                .when()
                .get("/api/v2/nodes/");
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
    @DisplayName("Register new Node in cluster")
    @Epic(value = "Nodes Nodes")
    @Story("Nodes")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a0bead07-901e-48e5-9d39-075b7de70b6a")
    @Feature("Register new Node in cluster")
    @Description("Register new Node")
    @Severity(SeverityLevel.MINOR)
    @Step ("Регистрация нового сервера в кластере.")
    public void setNewNode() {
        String requestBody = "{" +
                "\"nodes\":[{\"host\" :\"192.168.12.49\"," +
                "\"password\": \"1234\"," +
                "\"port\": \"8888\"}]}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/nodes/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(405)
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
    @DisplayName("Get Node detail info")
    @Epic(value = "Nodes Nodes")
    @Story("Nodes")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b6daa03f-b91d-4c40-83eb-05930f0dbab4")
    @Feature("Get detail info about Node")
    @Description("Get Node detail info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о сервере.")
    public void getNodeInfo() {

        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/");
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
    @DisplayName("Get list of all nodes in cluster")
    @Epic(value = "Nodes Nodes")
    @Story("Nodes")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#f35db011-cd8c-4f14-9062-ba84242e4e84")
    @Feature("Get Nodes list by cluster_id")
    @Description("Get list of all nodes in cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список всех серверах кластера.")
    public void getNodesClusterList() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "nodes/");
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
    @DisplayName("Get detail info about node services and disks")
    @Epic(value = "Nodes Node")
    @Story("Node")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a5aeae6f-3dc6-47bc-8a63-dd0370270af5")
    @Feature("Get Node detail info by node_id")
    @Description("Get detail info about node services and disks")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить детальную информацию о сервисах и дисках сервера.")
    public void getNodeDetailInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/");
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
    @DisplayName("Get node network list")
    @Epic(value = "Nodes Node")
    @Story("Node")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#945e19c6-fb01-49c7-a5ef-8f4d2848b145")
    @Feature("Get Node network list by node_id")
    @Description("Get node network list.")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о сети сервера.")
    public void getNodeNetworkInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/network/");
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
    @DisplayName("Get node network detail")
    @Epic(value = "Nodes Node")
    @Story("Node")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#f0589b45-f35d-4bd7-afa6-c448b3470679")
    @Feature("Get Node network detail by ifname")
    @Description("Get node network detail")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о сети сервера.")
    public void getNodeNetworkDetailInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/network/br0/");
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
    @DisplayName("Get default ip address for MDS")
    @Epic(value = "Nodes Node")
    @Story("Node")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#41c92ba4-8e79-450c-a608-dbc53337e65e")
    @Feature("Get default ip address for Metadata Server")
    @Description("Get default ip address for MDS")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить IP адрес сервера метаданных по умолчанию.")
    public void getMDSDefaultIP() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/default_mds_ipaddr/");
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
