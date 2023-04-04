import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ISCSI {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }
    @Test
    @DisplayName("Get iSCSI users info")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Users")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#45911e11-49c6-4efc-b204-5c257d80efbd")
    @Feature("iSCSI users info")
    @Description("Get iSCSI users info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список пользователей iSCSI.")
    public void getIscsiUsersInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/users/");
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
    @DisplayName("Add new iSCSI user")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Users")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#f6d89e3d-4131-4d83-897d-db8d6b637437")
    @Feature("Add iSCSI user")
    @Description("Add new iSCSI user")
    @Severity(SeverityLevel.MINOR)
    @Step ("Добавить нового пользователя iSCSI.")
    public void addNewIscsiUser() {
        JSONObject requestBody = new JSONObject()
                .put("password", "some_password")
                .put("username", "newISCSIUser")
                .put("is_enabled",true);
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/iscsi/users/")
                ;
        try {
            response.then()
                    .assertThat()
                    .statusCode(201)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 201 CREATED");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }



    @Test
    @DisplayName("Get iSCSI user info")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI User")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#f354c581-c870-4acf-b223-a92704b16d6e")
    @Feature("Get iSCSI user info by name")
    @Description("Get iSCSI user info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о пользователе iSCSI.")
    public void getIscsiUserInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/users/root/");
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
    @DisplayName("Change iSCSI user info")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI User")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#686b5623-65cd-4dd9-b619-9b4342ee90d1")
    @Feature("Change iSCSI user info by name")
    @Description("Change iSCSI user info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Изменить информацию о пользователе iSCSI.")
    public void setIscsiUser() {
        JSONObject requestBody = new JSONObject()
                .put("password", "new_password")
                .put("is_enabled",false);
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .put("/api/v2/"+TestStorage.cluster_id+"/iscsi/users/newISCSIUser")
                ;
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
    @DisplayName("Delete iSCSI user")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI User")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#78ef292e-64e1-4e37-b748-27ecc95bcc33")
    @Feature("Delete iSCSI user by name")
    @Description("Delete iSCSI user info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить пользователя iSCSI.")
    public void delIscsiUser() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/"+TestStorage.cluster_id+"/iscsi/users/newISCSIUser/")
                ;
        try {
            response.then()
                    .assertThat()
                    .statusCode(204)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 204 NO CONTENT");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Get all iSCSI targets Info")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Targets")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b4420e04-1756-4dee-8de5-3b25fc8333b8")
    @Feature("Get all iSCSI targets info")
    @Description("Get iSCSI targets info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список целей iSCSI.")
    public void getIscsiTargetsInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/")
                ;
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
    @DisplayName("Add new iSCSI target")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Targets")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#065bb299-7c34-470a-82a5-b9a78b5c8f36")
    @Feature("Add new iSCSI target")
    @Description("Add iSCSI target")
    @Severity(SeverityLevel.MINOR)
    @Disabled
    @Step ("Добавить новую цель iSCSI.")
    public void addIscsiTarget() {
        String requestBody = "{\n" +
                "    \"name\":\"123\",\n" +
                "    \"node_id\":\"849e6c83-1b10-489f-855a-dc2fa80271e2\",\n" +
                "    \"portals\":[\"192.168.12.49\"],\n" +
                "    \"owner\":\"root\",\n" +
                "    \"mut_owner\": \"root\",\n" +
                "    \"lun_size\": 100\n" +
                "}";
        System.out.println(requestBody);

        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .body(requestBody)
                .contentType("application/json")
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/")
                ;
        try {
            response.then()
                    .assertThat()
                    .statusCode(201)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 201 CREATED")
            ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Get iSCSI target Info by iqn")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Target")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#af052155-765b-424e-93b9-0441fa04fac2")
    @Feature("Get iSCSI target Info by iqn")
    @Description("Get iSCSI target Info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о цели iSCSI по iqn.")
    public void getIscsiTargetInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/");
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
    @DisplayName("Change iSCSI target")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Target")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#ca6f63c3-70c9-4944-9cd9-eaf222b866e3")
    @Feature("Change iSCSI target Info by iqn")
    @Description("Change iSCSI target Info")
    @Severity(SeverityLevel.MINOR)
    @Disabled
    @Step ("Изменить иинформацию цели iSCSI.")
    public void setIscsiTarget() {
        String requestBody = "{\n" +
                "    \"portals\":[\"192.168.12.49\"],\n" +
                "    \"owner\":\"root\",\n" +
                "    \"mut_owner\":\"root\",\n" +
                "    \"force\": \"true\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/");
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
    @DisplayName("Delete iSCSI target")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Target")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#04a5157a-13f2-4328-954b-d7612b8e1604")
    @Feature("Delete iSCSI target Info by iqn")
    @Description("Delete iSCSI target")
    @Severity(SeverityLevel.MINOR)
    @Disabled
    @Step ("Удалить цель iSCSI.")
    public void deleteIscsiTarget() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(204)
                    .statusLine("HTTP/1.1 204 NO CONTENT");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Start iSCSI target")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Target")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#1532a9d7-e6f0-499e-9f23-7b8cc6f0ba8a")
    @Feature("Start iSCSI target by iqn")
    @Description("Start iSCSI target")
    @Severity(SeverityLevel.MINOR)
    @Step ("Запустить цель iSCSI.")
    public void startIscsiTarget() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/start/")
                ;
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
    @DisplayName("Stop iSCSI target")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Target")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a0cde3d4-fabb-4db8-824e-23a80c6937de")
    @Feature("Stop iSCSI target by iqn")
    @Description("Stop iSCSI target")
    @Severity(SeverityLevel.MINOR)
    @Step ("Остановить цель iSCSI.")
    public void stopIscsiTarget() {
        String requestBody = "{\n" +
                "\"force\":\"true\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/stop/")
                ;
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
    @DisplayName("Get iSCSI initiators list")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI Initiators")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#1b503b14-7fbb-4b7f-947c-0c573f60bea8")
    @Feature("Get iSCSI initiators Info by iqn")
    @Description("Get iSCSI initiators Info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список инициаторов iSCSI.")
    public void getIscsiUnitiators() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/initiators/");
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
    @DisplayName("Get iSCSI LUN detail info")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI LUN details")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#35e0a0bf-bef8-425d-ba02-955544c98be1")
    @Feature("Get iSCSI LUN detail info by lunno")
    @Description("Add iSCSI LUN")
    @Step ("Получить список LUN'ов iSCSI.")
    public void getIscsiLunInfoD() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/luns/1/details/");
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
    @DisplayName("Get iSCSI LUN info by lunno")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI LUN")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#35e0a0bf-bef8-425d-ba02-955544c98be1")
    @Feature("Get iSCSI LUN detail info by lunno")
    @Description("Get iSCSI LUN info")
    @Step ("Получить информацию о LUN'е iSCSI по lunno.")
    public void getIscsiLunInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/luns/1/");
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
    @DisplayName("Delete iSCSI LUN")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI LUN")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#74d3d35e-410c-4d91-9321-435ff0419b9e")
    @Feature("Delete iSCSI LUN by lunno")
    @Description("Delete iSCSI LUN")
    @Disabled
    @Step ("Удалить LUN iSCSI.")
    public void deleteIscsiLunInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/" + TestStorage.cluster_id + "/iscsi/targets/iqn.2014-06.com.vstorage:123/luns/1/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(204)
                    .statusLine("HTTP/1.1 204 NO CONTENT");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }

    @Test
    @DisplayName("Get iSCSI LUNs info")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI LUNs")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#5a6ee368-5bf5-493d-8a52-cc4c36db8730")
    @Feature("Get iSCSI LUNs Info by iqn")
    @Description("Get iSCSI LUNs info")
    @Step ("Получить информацию о LUN'ах iSCSI.")
    public void getIscsiLuns() {
        String requestBody = "{\"cluster_name\":\"vs\",\n" +
                "\"host\":\"192.168.12.49\",\n" +
                "\"password\":\"1234\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/luns/");
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
    @DisplayName("Add new iSCSI LUN")
    @Epic(value = "Cluster iSCSI")
    @Story("iSCSI LUNs")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#dd78cb49-ec47-41f9-9b17-dd07e1066892")
    @Feature("Add new iSCSI LUN")
    @Description("Add iSCSI LUN")
    @Step ("Добавить новый LUN iSCSI.")
    public void addIscsiLuns() {
        String requestBody ="{" +
                "\"lunno\": \"1\",\n" +
                "\"size\": \"1073741824\",\n" +
                "\"description\": \"new Lun\",\n" +
                "\"redundancy\":{\"type\":\"raid6\",\"m\":\"1\",\"n\":\"2\"},\n" +
                "\"tier\":\"0\",\n" +
                "\"failure_domain\":\"host\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/iscsi/targets/iqn.2014-06.com.vstorage:123/luns/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(201)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 201 CREATED");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestStorage.getBody(response);
        }
    }



}
