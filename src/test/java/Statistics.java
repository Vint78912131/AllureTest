import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Statistics {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get cluster statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#12bf413b-9362-44a2-9f55-16b875e357a1")
    @Feature("Get cluster statistics")
    @Description("Get cluster statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить статистику кластера.")
    public void getClusterStat() {
        String params = "" +
                "{\"types\": [\"io_reads\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        /*type - include some of values:
         io_reads,
         io_writes,
         io_read_ops,
         io_write_ops,
         io_repl_reads,
         io_repl_writes,
         io_sync,
         io_datasync,
         cs_total,
         cs_active,
         mds_total,
         mds_avail*/
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/stat/");
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
    @DisplayName("Get Chunks Server statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a8245f7f-79b1-4579-bf0b-ab3b4bee6167")
    @Feature("Get Chunks Server statistics")
    @Description("Get Chunks Server statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить статистику серверов фрагментов кластера.")
    public void getCSStat() {
        String params = "" +
                "{\"types\": [\"io_reads\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        //type - include some of values:
        // io_reads,
        // io_writes,
        // io_read_ops,
        // io_write_ops,
        // io_repl_reads,
        // io_repl_writes,
        // io_sync,
        // io_datasync,
        // cs_total,
        // cs_active,
        // mds_total,
        // mds_avail
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/stat/cs/1/");
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
    @DisplayName("Get Metadata Server statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#75d3cef9-b272-4d1a-968d-399c54d127c7")
    @Feature("Get Metadata Server statistics")
    @Description("Get Metadata Server statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о серверах метаданных кластера.")
    public void getMDSStat() {
        String params = "" +
                "{\"types\": [\"ctime\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        //type - include some of values:
        // `ctime`,
        // `cpu_usage`,
        // `mem_usage`,
        // `uptime`
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/stat/mds/1/");
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
    @DisplayName("Get node statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#a00e8819-a727-424a-abc0-374eceaec3d7")
    @Feature("Get node statistics")
    @Description("Get node statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить статистику узлов кластера.")
    public void getNodeStat() {
        String params = "" +
                "{\"types\": [\"cpu_cores\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        //`type` - include some of values:
        // `cpu_idle',
        // `cpu_cores',
        // `mem_free',
        // `mem_total',
        // `dsk_reads',
        // `dsk_read_ops',
        // `dsk_writes',
        // `dsk_write_ops',
        // `net_tx'
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/stat/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/");
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
    @DisplayName("Get disk statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#36d329cc-dff9-42a6-9e69-40402480d6de")
    @Feature("Get disk statistics")
    @Description("Get disk statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить статистику дисков клсатера.")
    public void getDiskStat() {
        String params = "" +
                "{\"types\": [\"reads\",\"writes\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        //type - include some of values:
        // reads,
        // read_ops,
        // writes,
        // write_ops
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/stat/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/disks/1/");
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
    @DisplayName("Get network statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#0fc68d3d-ef25-4169-8618-042302a48de6")
    @Feature("Get network statistics")
    @Description("Get network statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить сетевую статистику кластера.")
    public void getNetStat() {
        String params = "" +
                "{\"types\": [\"status\",\"tx_drops\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        //type - include some of values:
        // status,
        // tx,
        // rx,
        // tx_drops,
        // rx_drops
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/stat/nodes/059ac5a5-0724-4d66-a09b-a9163ba00859/network/br0/");
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
    @DisplayName("Get Object Store cluster statistics")
    @Epic(value = "Statistics")
    @Story("Statistics")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#332cb2bc-351e-4b10-9333-cf548d4b7100")
    @Feature("Get Object Store cluster statistics")
    @Description("Get Object Store cluster statistics")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить статистику кластера S3.")
    public void getS3Stat() {
        String params = "" +
                "{\"types\": [\"os_total\",\"s3gw_total\"], " +
                "\"filters\": " +
                "{\"from\": \"2023-03-23T21:10:00\", " +
                "\"to\": \"2023-03-23T21:20:00\"}}";
        //type - include some of values:
        // os_total,
        // os_avail,
        // ns_total,
        // ns_avail,
        // s3gw_total,
        // s3gw_avail,
        // ns_rps,
        // os_rps,
        // s3gw_rps
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("params",params)
                .when()
                .get("/api/v2/" + TestStorage.cluster_id + "/stat/s3/");
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
