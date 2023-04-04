import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class License {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get cluster license info")
    @Epic(value = "Cluster License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#67851231-cb02-4aeb-b296-dc2a618bb30b")
    @Feature("Get cluster license")
    @Description("Get cluster license info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о лицензии кластера.")
    public void getClusterLicenseInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+ TestStorage.cluster_id+"/license/");
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
    @DisplayName("Update cluster license")
    @Epic(value = "Cluster License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#17f22073-d8cd-452f-9f43-c074da1390bb")
    @Feature("Update cluster license")
    @Description("Update cluster license by cluster_id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Обновить лицензию кластера.")
    public void updateClusterLicense() {
        String requestBody = "{" +
                "\"server\":\"849e6c831b10489f855adc2fa80271e2\"" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/license/keys/update/");
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
    @DisplayName("Register new cluster license")
    @Epic(value = "Cluster License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#9c997ee7-e38f-481a-8038-1872898b973c")
    @Feature("Register new cluster license")
    @Description("Register new cluster license by cluster_id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Регистрация новой лицензии кластера.")
    public void registerNewClusterLicense() {
        String requestBody = "{" +
                "\"key\":\"someKeyFor_849e6c831b10489f855adc2fa80271e2\"" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/license/keys/register/");
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
    @DisplayName("Get cluster license info")
    @Epic(value = "Cluster License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#02f30e35-7aab-46f7-8668-a714419a8e96")
    @Feature("Get cluster license info")
    @Description("Get cluster license info as")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о лицензии кластера.")
    public void getClusterLicenseAs() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/license/as/");
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
    @DisplayName("Check cluster license")
    @Epic(value = "Cluster License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#2fcbd99f-2a1d-4822-b315-7c5133c8157d")
    @Feature("Check cluster license info")
    @Description("Check cluster license info by params")
    @Severity(SeverityLevel.MINOR)
    @Step ("Проверить лицензию кластера.")
    public void checkClusterLicense() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("key","keyNumber")
                .param("type","prolong") //prolong, update
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/license/as/test/");
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
    @DisplayName("Get cluster license")
    @Epic(value = "License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#9197e300-51a7-4926-b543-cd4ab933c02a")
    @Feature("Get cluster license")
    @Description("Get cluster license")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить лицензию кластера.")
    public void getClusterLicense() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/license/as/");
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
    @DisplayName("Activate license keys")
    @Epic(value = "License")
    @Story("License")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#71af9a41-4458-4b75-8df6-09f0dde4e72e")
    @Feature("Activate license keys")
    @Description("Activate license keys")
    @Severity(SeverityLevel.MINOR)
    @Step ("Активировать лицензию кластера.")
    public void setClusterLicense() {
        String requestBody = "{" +
                "    \"keys\": \"some_cluster_key\"," +
                "    \"type\":\"prolong\"" +
                "}";
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/"+TestStorage.cluster_id+"/license/as/");
        try {
            response.then()
                    .assertThat()
                    .statusCode(405)
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
