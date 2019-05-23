package api;

import base.BaseApiTest;
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
    public void getListSpecificIntegerApi() {
        List<Integer> values = ApiTestingOperations.getSpecificAllIntegerApi("/api/unknown", "data.id");
        for (int item : values) {
            System.out.println(item);
        }
    }

    @Test
    public void getListSpecificStringApi() {
        List<String> values = ApiTestingOperations.getSpecificAllStringApi("/api/unknown", "data.name");
        for (String item : values) {
            System.out.println(item);
        }
    }

    @Test
    public void getStringApi() {
        String value = ApiTestingOperations.getOnlyOneStringApi("/api/unknown", "data[1].color");
        System.out.println(value);
    }

    @Test
    public void getIntegerApi() {
        int value = ApiTestingOperations.getOnlyOneIntegerApi("/api/unknown", "data[1].year");
        log.info(value);
    }

    @Test
    public void uniqueIdControl() {//Control the ids are unique
        List<Integer> values = ApiTestingOperations.getSpecificAllIntegerApi("/api/unknown", "data.id");
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(i).equals(values.get(j))) {
                    Assert.fail();
                }
            }
        }
        log.info("All ids are unique");
    }


}
