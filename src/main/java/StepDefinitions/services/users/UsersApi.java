package StepDefinitions.services.users;

import StepDefinitions.services.base.BaseService;
import Utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.response.users.UsersResponsePojo;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class UsersApi extends BaseService {

	private static Response response = null;
	private static UsersResponsePojo[] usersResponsePojo;
	private static Logger logger = LoggerFactory.getLogger(UsersApi.class);
	public static int userId = 0;
	public static int userNameFoundStatus = 0;


	@Given("a user with username {string}")
	public void aUserWithUsername(String userName) {
		Assert.assertTrue(userName != null && !userName.isEmpty());
	}

	@When("users api is invoked for username {string}")
	public static void usersApiIsInvokedForUsername(String userName) {
		String endPoint = properties.getProperty("usersApiEndpoint");
		HashMap<String, String> queryParams = new HashMap();
		queryParams.put("username", userName);
		response = getRestDriver().getRequest(endPoint, queryParams);
	}

	@Then("response status code should be {string}")
	public void responseStatusCodeShouldBe(String expectedResponseStatusCode) {
		TestUtils.validateResponseStatusCode(response, Integer.valueOf(expectedResponseStatusCode));
	}

	@And("userId retrieval should be {string} for username {string}")
	public static void userIdRetrieval(String expectedRetrivalStatus,String userName) {
		try {
			usersResponsePojo = response.getBody().as(UsersResponsePojo[].class);
			logger.info("userNameFoundStatus:" + userNameFoundStatus + " for userName:" + userName);
			logger.info("userNameFoundStatus:" + userNameFoundStatus);
			switch (expectedRetrivalStatus) {

			case "PASS":
				userId = usersResponsePojo[0].getId();
				Assert.assertTrue("userId validation for user:" + userName, userId > 0);
				Assert.assertTrue(usersResponsePojo.length > 0);
				logger.info("UserId is :" + userId + " for userName:" + userName);
				break;

			case "FAIL":
				userId = 0;
				Assert.assertEquals(0, usersResponsePojo.length);
				break;
			}
		} catch (Exception e) {
			logger.info("Exception while retrieving user id for user:" + userName);
		}
	}

	@When("user id is retrieved for username {string}")
	public static int getUserId(String userName) {
		try {
			usersApiIsInvokedForUsername(userName);
			if(userNameFoundStatus==1) {
				userIdRetrieval("PASS",userName);
			}else {
				userIdRetrieval("FAIL",userName);
			}
		} catch (Exception e) {
			logger.info("Exception in getting the userId for :" + userName);
		}
		return userId;
	}

	@And("the username {string} validity is determined")
	public void theUsernameIsValid(String userName) {		
		checkIfUserNameIsFound(userName);        
	}



	/**
	 * @param userName - the userName to check for in /users response
	 * @return userNameFoundStatus -
	 * returns 1 if userName is valid.
	 * returns 0 if userName is invalid or not found.
	 */
	private static int checkIfUserNameIsFound(String userName) {
		userNameFoundStatus = 0;
		Response allUsersResponse = restDriver.getRequest(properties.getProperty("usersApiEndpoint"));
		UsersResponsePojo[] allUsersResponsePojo = allUsersResponse.getBody().as(UsersResponsePojo[].class);
		for (UsersResponsePojo ele : allUsersResponsePojo) {
			String userNameVar = ele.getUsername();
			if (userNameVar.equals(userName)) {
				logger.info("Username:" + userName + " found in users API response!");
				userNameFoundStatus = 1;
				break;
			}
		}
		return userNameFoundStatus;
	}

}
