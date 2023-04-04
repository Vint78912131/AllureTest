import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Events {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }
    @Test
    @DisplayName("Get cluster events")
    @Epic(value = "Cluster")
    @Story("Cluster Events")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#5ee7197c-52d5-45fe-ae4d-65f2e1220d7c")
    @Feature("Get cluster events")
    @Description("Get cluster events")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список событий кластера.")
    public void getClusterEvents() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/events/");
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
    @DisplayName("Get cluster events by params")
    @Epic(value = "Cluster")
    @Story("Cluster Events")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#5ee7197c-52d5-45fe-ae4d-65f2e1220d7c")
    @Feature("Get cluster events by params")
    @Description("Get cluster events by params")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить события кластера по параметрам.")
    public void getClusterEventBy() {
        /*params
        {"fields": ["name1", "name2", ..., "nameN"],
          "lastn": int, "page": int, "limit": int,
          "filters":{"beg": "YYYY-mm-ddTHH:MM:SS.ffffff", "end": "YYYY-mm-ddTHH:MM:SS.ffffff",
           "sys": ["sys1","sys2",...,"sysN"],
           "sev":["sev1","sev2",...,"sevN"], "submsg": str}}

        fields -- Field names to output [json list] (default: all)
        page -- Page index [1..N] (defaault: 1)
        limit -- Events per page [1..N] (default: 20)
        lastn -- Last N events [1..N] (default: all)
        beg -- Begin date inclusive [ISO8601 format: "YYYY-mm-ddTHH:MM:SS.ffffff"] (default: min date)
        end -- End date exclusive [ISO8601 format: "YYYY-mm-ddTHH:MM:SS.ffffff"] (default: max date)
        sys -- List of subsystems or string [JRN,MDS,CS,FUS,CLN,MON,TLS,TST,ADM,???] (default: all)
        sev -- List of severities or string [ERR,INF,WRN,DBG,???] (default: all)
        submsg -- Submessage (some text) (default: empty string)*/
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .param("page",1)
                .when()
                .get("/api/v2/"+TestStorage.cluster_id+"/events/");
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
