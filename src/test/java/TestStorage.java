import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class TestStorage {

    public static String endpoint = "https://192.168.12.50:8888/";
    public static String session = null;
    public static String cookies = null;
    public static Integer cluster_id = null;
    public static String cluster_name = null;

    public static void setCookies () {
        RestAssured.baseURI = endpoint;
        JSONObject requestBody = new JSONObject()
                .put("password", "1234")
                .put("username", "root");
        cookies = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/api/v2/login/")
                .getDetailedCookies().toString();
        cluster_id = 3;
        cluster_name = "newCluster";
    }

    @Attachment(value = "Response", type = "application/json", fileExtension = ".txt")
    public static String getBody (Response response) {
        return response.getBody().prettyPrint();
    }
}
