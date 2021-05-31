package StepDefinitions.services.comments;

import StepDefinitions.services.base.BaseService;
import StepDefinitions.services.posts.PostsApi;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import models.response.comments.CommentsResponsePojo;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentsApi extends BaseService {

	private static Response response = null;
	private static Logger logger = LoggerFactory.getLogger(CommentsApi.class);
	private List<Integer> postIdList = PostsApi.postIdList;
	private List<String> commentsEmailIdList;
	private CommentsResponsePojo[] commentsResponsePojo;


	@And("comments api is invoked for all the posts created by username {string}")
	public void commentsApiIsInvokedForAllThePostsCreatedByUsername(String userName) {

		HashMap<String,Integer> queryParams = new <String,Integer> HashMap();
		commentsEmailIdList = new ArrayList<>();
		String endPoint = properties.getProperty("commentsApiEndpoint");

		//for each postId ,get the list of Comments
		for (int postId : postIdList) {
			queryParams.put("postId", postId);
			logger.info("Invoking Comments API for PostID:" + postId + ";UserName:" + userName);
			response = restDriver.getRequest(endPoint, queryParams);
			commentsResponsePojo = response.getBody().as(CommentsResponsePojo[].class);
			for(CommentsResponsePojo ele:commentsResponsePojo){
				String commentEmail = ele.getEmail();
				commentsEmailIdList.add(commentEmail);
			}
		}
		logger.info("Here are all the commentsEmails for userName:" + userName + ":-" + commentsEmailIdList);
	}


	@And("comments response email format validation should {string} for username {string}")
	public void commentsResponseShouldContainValidEmailFormatForUsername(String expectedValidationStatus,String userName) {

		switch (expectedValidationStatus) {
		case "PASS":
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			Pattern pattern = Pattern.compile(regex);

			//validate the emails format under comments
			for(String commentEmail:commentsEmailIdList){
				Matcher matcher = pattern.matcher(commentEmail);
				Assert.assertTrue(matcher.matches());
				logger.info("comment email:" + commentEmail + " is of valid format!");
			}
			logger.info("Emails format validation for username:" + userName + ";PASS!");
			break;
			
		case "FAIL" : Assert.assertTrue("Checking if list of comments retrieved for username:" + userName + " is 0", commentsEmailIdList.size()==0);
		break;

		default:
			break;
		}

	}
}
