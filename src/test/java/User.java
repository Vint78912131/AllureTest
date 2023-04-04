import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class User {

    @BeforeEach
    public void preparation() {
        TestStorage.setCookies();
    }

    @Test
    @DisplayName("Get Storage users info")
    @Epic(value = "User")
    @Story("User Users")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#18b47558-a2d2-4a15-9222-1bfdb18fbf6b")
    @Feature("Get Storage all users info")
    @Description("Get Storage users info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить инфорацию о пользователях Р-Хранилища.")
    public void getUsersInfo() {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .get("/api/v2/users/");
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
    @DisplayName("Create new Storage user")
    @Epic(value = "User")
    @Story("User Users")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#b4cd28b1-e76f-4313-af78-941fc887c593")
    @Feature("Create new Storage user")
    @Description("Create new Storage user")
    @Severity(SeverityLevel.MINOR)
    @Step ("Создать нового пользователя Р-Хранилища.")
    public void addNewStorageUser() {
        String requestBody = "{\n" +
                "    \"username\": \"new_user2\",\n" +
                "    \"password\": \"1q2w3e\",\n" +
                "    \"description\": \"another user\",\n" +
                "    \"is_enabled\": \"true\"\n" +
                "}";
        /*Request body Description
description, is_enabled, can_adit is optional.
is_enabled - Default: false*/
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v2/users/");
        try {
            response.then()
                    .assertThat()
//                    .statusCode(404)
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
    @DisplayName("Get Storage user info by id")
    @Epic(value = "User")
    @Story("User User")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#2e4c4d1f-b9d2-41b2-ba4f-1d4d47681e93")
    @Feature("Get Storage user info by id")
    @Description("Get Storage user info by id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить информацию о пользователе Р-Хранилища по id.")
    public void getStorageUserInfo () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .post("/api/v2/user/1/");
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
    @DisplayName("Change Storage user info")
    @Epic(value = "User")
    @Story("User User")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#6039fe8d-4cb6-4880-bf46-55ff25111cd1")
    @Feature("Change Storage user info")
    @Description("Change Storage user info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Изменить данные пользователя Р-Хранилища.")
    public void setStorageUserInfo () {
        String requestBody = "{\n" +
                "    \"username\":\"newUser\",\n" +
                "    \"password\":\"newPassword123\",\n" +
                "    \"description\":\"testing\",\n" +
                "    \"is_enabled\":\"false\"\n" +
                "}";
        /*Modify a user.
The superuser is allowed to modify all fields, except is_superuser.
All fields is optional.
Another users is allowed to modify yours own password only*/
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/v2/user/1/");
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
    @DisplayName("Delete Storage user by id")
    @Epic(value = "User")
    @Story("User User")
    @Link("https://documenter.getpostman.com/view/607407/UVRGFjMf#196c449e-8051-4f61-ac0f-acce7bcd6ced")
    @Feature("Delete Storage user by id")
    @Description("Delete Storage user by id")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить пользователя Р-Хралищиа по id.")
    public void deleteStorageUser () {
        Response response = RestAssured
                .given()
                .cookie(TestStorage.cookies)
                .contentType("application/json")
                .when()
                .delete("/api/v2/user/1/");
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
