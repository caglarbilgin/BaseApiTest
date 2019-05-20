package api;

import base.BaseApiTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ApiTestingOperations;

import java.util.List;

public class ApiTest extends BaseApiTest {
    @Before
    public void baseTest() {
        apiPreparation();

    }

    @Test
    //You can send the path(like "/posts") and json path(like "id") what you get all Integer response you want to get
    public void getFullSpecificIntegerApi() {
        List<Integer> values = ApiTestingOperations.getSpecificAllIntegerApi("/posts", "id");
        for (int item : values) {
            System.out.println(item);
        }
    }

    @Test //You can send the path and json path what you get all string response you want to get
    public void getFullSpecificStringApi() {
        List<String> values = ApiTestingOperations.getSpecificAllStringApi("/posts", "title");
        for (String item : values) {
            System.out.println(item);
        }
    }

    @Test //You can send the path and json path what only 1 string response you want to get
    public void getStringApi() {
        String value = ApiTestingOperations.getOnlyOneStringApi("/posts", "title[1]");
        System.out.println(value);
    }

    @Test //You can send the path and json path  what only 1 integer response you want to get
    public void getIntegerApi() {
        int value = ApiTestingOperations.getOnlyOneIntegerApi("/posts", "id[1]");
        System.out.println(value);
    }

    @Test
    public void uniqueIdControl() {
        List<Integer> values = ApiTestingOperations.getSpecificAllIntegerApi("/posts", "id");
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(i).equals(values.get(j))) {
                    Assert.fail();
                }else{
                    log.info("All ids are unique");
                }
            }
        }
    }
}
