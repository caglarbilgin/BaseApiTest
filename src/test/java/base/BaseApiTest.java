package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

public class BaseApiTest {
    protected static final Logger log = Logger.getLogger(BaseApiTest.class);

    public static void apiPreparation(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }
}