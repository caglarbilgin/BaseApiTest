package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.*;

public class BaseApiTest {


    public static void apiPreparation() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }

    public static JSONObject readDataFromFile(String jsonData) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser
                    .parse(new FileReader(jsonData));
            JSONObject jsonObject = (JSONObject) object;
            System.out.println(jsonObject);
            return jsonObject;

        } catch (Exception e) {
            return null;
        }

    }
}
