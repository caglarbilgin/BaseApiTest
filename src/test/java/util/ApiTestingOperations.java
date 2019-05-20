package util;

import api.ApiTest;
import base.BaseApiTest;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTestingOperations extends BaseApiTest {

    protected static final Logger log = Logger.getLogger(ApiTest.class);

    public static  Response getFullApi(String path){
        Response getApi =
                given()
                        .when()
                        .get(path)
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();
        return  getApi;
    }
    public static List<Integer> getSpecificAllIntegerApi(String path , String apiJsonPath) {
       Response getApi = getFullApi(path);

        List<Integer> values = getApi.jsonPath().getList(apiJsonPath);
        log.info(values.size());
        return values;
    }

    public static List<String> getSpecificAllStringApi(String path, String apiJsonPath) {
        Response getApi = getFullApi(path);

        List<String> values = getApi.jsonPath().getList(apiJsonPath);
        log.info(values.size());
        return values;
    }

    public static String getOnlyOneStringApi(String path, String apiJsonPath) {
        Response getApi = getFullApi(path);
        String value = getApi.jsonPath().get(apiJsonPath);
        return value;

    }

    public static int getOnlyOneIntegerApi(String path, String apiJsonPath){
        Response getApi = getFullApi(path);
        int value = getApi.jsonPath().get(apiJsonPath);
        return value ;
    }



}
