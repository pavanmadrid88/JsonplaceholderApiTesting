package Utils;

import io.restassured.response.Response;
import org.junit.Assert;

public class TestUtils {

    /**
     * This method validates a given response with a given response statusCode
     * @param response - response to be checked
     * @param statusCode - expected status code
     */
    public static void validateResponseStatusCode(Response response, int statusCode){
        Assert.assertEquals(statusCode,response.statusCode());
    }

    public void test(){

    }




}
