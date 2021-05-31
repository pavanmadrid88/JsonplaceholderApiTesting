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


	/**
	 * This method validates a given response with a given response statusLine
	 * @param response - response to be checked
	 * @param statusLine - expected status Line
	 */
	public static void validateResponseStatusLine(Response response, String statusLine){
		Assert.assertEquals(statusLine,response.statusLine());        
	}

}
