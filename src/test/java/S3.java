import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class S3 {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get ostor cluster detail")
    @Epic(value = "S3 Ostor Cluster")
    @Story("Ostor Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#5bfc4586-0a04-4ccd-9731-51f4d80d2c49")
    @Feature("Get ostor cluster detail info")
    @Description("Get ostor cluster detail info by cluster_id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить детальную информацию о кластере S3.")
    public void getOstoreClusterInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/s3/");
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
    @DisplayName("Create ostor cluster")
    @Epic(value = "S3 Ostor Cluster")
    @Story("Ostor Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#8c246158-7be5-4e68-a39b-cb74589c3c0d")
    @Feature("Create ostor cluster")
    @Description("Create new ostor cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Создать новый кластер S3.")
    public void setNewOstoreCluster() {
        String requestBody = "{\"data\":{\n" +
                "    \"nodes\":[\n" +
                "        {\n" +
                "        \"id\": \"059ac5a5-0724-4d66-a09b-a9163ba00859\",\n" +
                "        \"priv_net_if\": \"br1\",\n" +
                "        \"pub_net_if\": [\n" +
                "          \"192.168.12.45\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"849e6c83-1b10-489f-855a-dc2fa80271e2\",\n" +
                "        \"priv_net_if\": \"br1\",\n" +
                "        \"pub_net_if\": [\n" +
                "          \"192.168.12.46\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"2f56b362-e93b-45d4-af91-637daf472fed\",\n" +
                "        \"priv_net_if\": \"br1\",\n" +
                "        \"pub_net_if\": [\n" +
                "          \"192.168.12.47\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"n_ns\":\"192.168.12.49\",\n" +
                "    \"n_os\":\"192.168.12.49\",\n" +
                "    \"s3gw_domain\":\"s3.RP.ru\",\n" +
                "    \"tier\":\"0\",\n" +
                "    \"redundancy\":{\n" +
                "        \"type\": \"raid6\",\n" +
                "        \"m\":\"1\",\n" +
                "        \"n\":\"2\"\n" +
                "    }\n" +
                "}\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(404)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }


    @Test
    @DisplayName("Create ostor cluster sync")
    @Epic(value = "S3 Ostor Cluster")
    @Story("Ostor Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#6cd3467c-f095-4a12-8f85-4aa49391f629")
    @Feature("Create ostor cluster")
    @Description("Create new ostor cluster sync")
    @Severity(SeverityLevel.MINOR)
    @Step ("Создать новый кластер S3 sync.")
    public void setNewOstoreClusterSync() {
        String requestBody = "{\"data\":{\n" +
                "    \"nodes\":[\n" +
                "        {\n" +
                "        \"id\": \"059ac5a5-0724-4d66-a09b-a9163ba00859\",\n" +
                "        \"priv_net_if\": \"br1\",\n" +
                "        \"pub_net_if\": [\n" +
                "          \"192.168.12.45\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"849e6c83-1b10-489f-855a-dc2fa80271e2\",\n" +
                "        \"priv_net_if\": \"br1\",\n" +
                "        \"pub_net_if\": [\n" +
                "          \"192.168.12.46\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"2f56b362-e93b-45d4-af91-637daf472fed\",\n" +
                "        \"priv_net_if\": \"br1\",\n" +
                "        \"pub_net_if\": [\n" +
                "          \"192.168.12.47\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ],\n" +
                "    \"n_ns\":\"192.168.12.49\",\n" +
                "    \"n_os\":\"192.168.12.49\",\n" +
                "    \"s3gw_domain\":\"s3.RP.ru\",\n" +
                "    \"tier\":\"0\",\n" +
                "    \"redundancy\":{\n" +
                "        \"type\": \"raid6\",\n" +
                "        \"m\":\"1\",\n" +
                "        \"n\":\"2\"\n" +
                "    }\n" +
                "}\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
//                .param("sync","")
                .body(requestBody)
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/?sync");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(404)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Create ostor cluster PUT")
    @Epic(value = "S3 Ostor Cluster")
    @Story("Ostor Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a50470e3-53c5-415c-9348-949d22e7a7af")
    @Feature("Create ostor cluster PUT")
    @Description("Create new ostor cluster PUT")
    @Severity(SeverityLevel.MINOR)
    @Step ("Создать новый кластер S3 PUT.")
    public void setNewOstoreClusterPut() {
        String requestBody = "{\"data\":{\n" +
                "    \"nodes\":[\n" +
                "        {\n" +
                "            \"id\":\"849e6c83-1b10-489f-855a-dc2fa80271e2\",\n" +
                "            \"priv_net_if\":\"192.168.12.46\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"n_ns\":\"192.168.12.49\",\n" +
                "    \"n_os\":\"192.168.12.49\",\n" +
                "    \"s3gw_domain\":\"s3.RP.ru\",\n" +
                "    \"tier\":\"0\",\n" +
                "    \"redundancy\":{\n" +
                "        \"type\": \"raid1\",\n" +
                "        \"m\":\"1\",\n" +
                "        \"n\":\"2\"\n" +
                "    }\n" +
                "}\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/v2/" + TestStorage.cluster_id + "/s3/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(404)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Create ostor cluster PUT sync")
    @Epic(value = "S3 Ostor Cluster")
    @Story("Ostor Cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#9671a2cf-98ec-4b28-a46d-19a40db49947")
    @Feature("Create ostor cluster PUT sync")
    @Description("Create new ostor cluster PUT sync")
    @Severity(SeverityLevel.MINOR)
    @Step ("Создать новый кластер S3 PUT sync.")
    public void setNewOstoreClusterPutSync() {
        String requestBody = "{\"data\":{\n" +
                "    \"nodes\":[\n" +
                "        {\n" +
                "            \"id\":\"849e6c83-1b10-489f-855a-dc2fa80271e2\",\n" +
                "            \"priv_net_if\":\"192.168.12.46\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"n_ns\":\"192.168.12.49\",\n" +
                "    \"n_os\":\"192.168.12.49\",\n" +
                "    \"s3gw_domain\":\"s3.RP.ru\",\n" +
                "    \"tier\":\"0\",\n" +
                "    \"redundancy\":{\n" +
                "        \"type\": \"raid1\",\n" +
                "        \"m\":\"1\",\n" +
                "        \"n\":\"2\"\n" +
                "    }\n" +
                "}\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/v2/" + TestStorage.cluster_id + "/s3/?sync");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(404)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Object store overview details")
    @Epic(value = "S3 Ostor Overview")
    @Story("Ostor Overview")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#2171c31c-dffe-404e-9909-02be4a416b54")
    @Feature("Get S3 store info")
    @Description("Object store overview details")
    @Severity(SeverityLevel.MINOR)
    @Step ("Обзор кластера S3.")
    public void getOstoreOverview() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/s3/overview/");
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
    @DisplayName("Assign nodes to ostor cluster")
    @Epic(value = "S3 Assign nodes to ostor cluster")
    @Story("Assign nodes to ostor cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#2c35cd3a-e6e2-4dba-b520-937ebd2645ac")
    @Feature("Assign nodes to ostor cluster")
    @Description("Assign nodes to ostor cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Назначить узел в кластер S3.")
    public void setOstoreOverview() {
        String requestBody = "{\n" +
                "    \"nodes\":[\n" +
                "        {\n" +
                "            \"id\":\"2f56b362-e93b-45d4-af91-637daf472fed\",\n" +
                "            \"priv_net_if\":\"br1\",\n" +
                "            \"pub_net_if\":\"192.168.22.47\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/nodes/assign/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Assign nodes to ostor cluster sync")
    @Epic(value = "S3 Assign nodes to ostor cluster")
    @Story("Assign nodes to ostor cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#2c35cd3a-e6e2-4dba-b520-937ebd2645ac")
    @Feature("Assign nodes to ostor cluster sync")
    @Description("Assign nodes to ostor cluster sync")
    @Severity(SeverityLevel.MINOR)
    @Step ("Назначить узел в кластер S3 sync.")
    public void setOstoreOverviewSync() {
        String requestBody = "{\n" +
                "    \"nodes\":[\n" +
                "        {\n" +
                "            \"id\":\"2f56b362-e93b-45d4-af91-637daf472fed\",\n" +
                "            \"priv_net_if\":\"br1\",\n" +
                "            \"pub_net_if\":\"192.168.22.47\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/nodes/assign/?sync");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }


    @Test
    @DisplayName("Release nodes from ostor cluster sync")
    @Epic(value = "S3 Assign nodes to ostor cluster")
    @Story("Assign nodes to ostor cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#3d338201-1007-420a-9709-4c72bcfb6e57")
    @Feature("Release nodes from ostor cluster")
    @Description("Release nodes from ostor cluster sync")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить узел из кластера S3 sync.")
    public void releaseNodeSync() {
        String requestBody = "{\"nodes\": [\"2f56b362-e93b-45d4-af91-637daf472fed\"]}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/nodes/release/?sync=null");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Release nodes from ostor cluster")
    @Epic(value = "S3 Assign nodes to ostor cluster")
    @Story("Assign nodes to ostor cluster")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#3d338201-1007-420a-9709-4c72bcfb6e57")
    @Feature("Release nodes from ostor cluster")
    @Description("Release nodes from ostor cluster")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить узел из кластера S3.")
    public void releaseNode() {
        String requestBody = "{\"nodes\": [\"2f56b362-e93b-45d4-af91-637daf472fed\"]}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/nodes/release/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(202)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }


    @Test
    @DisplayName("Get S3 users info")
    @Epic(value = "S3 S3 users list")
    @Story("S3 users list")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#bfd6807e-6354-4617-9a70-607d3591f168")
    @Feature("Get all S3 users")
    @Description("Get all S3 users list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о пользователях кластера S3.")
    public void getOstoreUsers() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/s3/users/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Add new S3 user")
    @Epic(value = "S3 S3 users list")
    @Story("S3 users list")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#dd59bc0b-611b-483e-8bf9-f2285caeab2a")
    @Feature("Add new S3 user")
    @Description("Add new S3 user")
    @Severity(SeverityLevel.MINOR)
    @Step ("Добавить нового пользователя в кластер S3.")
    public void setNewOstoreUser() {
        String requestBody = "{\n" +
                "    \"email\": \"rp2@rosplatforma.ru\",\n" +
                "    \"description\":\"rp2\",\n" +
                "    \"is_enabled\":\"true\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/" + TestStorage.cluster_id + "/s3/users/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Get all S3 user info")
    @Epic(value = "S3 S3 user detail")
    @Story("S3 user detail")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#62b70e1d-8872-4c51-9557-0a458e3b288c")
    @Feature("Get all S3 user info")
    @Description("Get all S3 user info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о всех пользователях кластера S3.")
    public void getOstoreUserInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/s3/users/1/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Change S3 user info")
    @Epic(value = "S3 S3 user detail")
    @Story("S3 user detail")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#51debb04-7d68-40c1-aa91-2ba5a19cfef8")
    @Feature("Change S3 user info")
    @Description("Change S3 user info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Изменить информацию о пользователе кластера S3.")
    public void setOstoreUser() {
        String requestBody = "{\n" +
                "    \"description\": \"This is a good fellow\",\n" +
                "    \"is_enabled\": true\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/v2/" + TestStorage.cluster_id + "/s3/users/1/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }


    @Test
    @DisplayName("Delete S3 user by user_id")
    @Epic(value = "S3 S3 user detail")
    @Story("S3 user detail")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#51debb04-7d68-40c1-aa91-2ba5a19cfef8")
    @Feature("Delete S3 user by user_id")
    @Description("Delete S3 user by user_id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить пользователя из кластера S3.")
    public void deleteOstoreUser() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/" + TestStorage.cluster_id + "/s3/users/1/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Get all S3 buckets info")
    @Epic(value = "S3 S3 bucket list")
    @Story("S3 bucket list")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#6f289e09-93ee-4600-93cf-c62bbfbc12f9")
    @Feature("Get all S3 buckets info")
    @Description("Get all S3 buckets info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о корзинах кластера S3.")
    public void getOstoreBucketInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/s3/buckets/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Change the bucket registration in Notary Provider")
    @Epic(value = "S3 S3 bucket change")
    @Story("S3 bucket change")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#87ad33d0-1d55-4f6e-b0c9-cc6ec5549f72")
    @Feature("Change the bucket registration in Notary Provider")
    @Description("Change the bucket registration in Notary Provider")
    @Severity(SeverityLevel.MINOR)
    @Step ("Изменить данные доверенного центра для корзины кластера S3.")
    public void setOstoreBucket() {
        String requestBody = "{\n" +
                "    \"is_np\":\"true\"\n" +
                "}";
        //is_np - is bucket registered with Notary Provider.
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/v2/" + TestStorage.cluster_id + "/s3/buckets/test_bucket/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(200)
                    .contentType("application/json")
//                    .statusLine("HTTP/1.1 200 OK")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }


}
