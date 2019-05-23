package util;

import base.BaseApiTest;
import io.restassured.response.Response;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ApiTestingOperations extends BaseApiTest {


    public static Response getFullApi(String path) {
        Response getApi =
                given()
                        .when()
                        .get(path)
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();

        return getApi;
    }

    //You can send the path(like "/posts") and json path(like "id") what you get List of Integer response you want to get
    public static List<Integer> getSpecificAllIntegerApi(String path, String apiJsonPath) {
        Response getApi = getFullApi(path);

        List<Integer> values = getApi.jsonPath().getList(apiJsonPath);
        return values;
    }

    //You can send the path and json path what you get list of string response you want to get
    public static List<String> getSpecificAllStringApi(String path, String apiJsonPath) {
        Response getApi = getFullApi(path);

        List<String> values = getApi.jsonPath().getList(apiJsonPath);
        return values;
    }

    //You can send the path and json path what only one string response you want to get
    public static String getOnlyOneStringApi(String path, String apiJsonPath) {
        Response getApi = getFullApi(path);
        String value = getApi.jsonPath().get(apiJsonPath);
        return value;

    }

    //You can send the path and json path  what only one integer response you want to get
    public static int getOnlyOneIntegerApi(String path, String apiJsonPath) {
        Response getApi = getFullApi(path);
        int value = getApi.jsonPath().get(apiJsonPath);
        return value;
    }


}
