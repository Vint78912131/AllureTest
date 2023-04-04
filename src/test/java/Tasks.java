import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tasks {
    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get Tasks info list")
    @Epic(value = "Tasks")
    @Story("Tasks")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b6a6b8d8-b7c4-4c30-9232-2046aff84e2e")
    @Feature("Get Tasks info list")
    @Description("Get Tasks info list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список серверных задач.")
    public void getTasksInfo () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/tasks/");
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
    @DisplayName("Get Task info by id")
    @Epic(value = "Tasks")
    @Story("Tasks")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#dbb04b36-3f63-46b5-8e28-ad608fd0345c")
    @Feature("Get Task info by id")
    @Description("Get Task info by id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о серверной задаче по id.")
    public void getTaskInfoBy () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/tasks/12f6d6a5-f6d2-487b-a3f4-e4bbf3e9b934");
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
