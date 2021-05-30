package StepDefinitions.services.posts;

import StepDefinitions.services.base.BaseService;
import StepDefinitions.services.users.UsersApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.response.posts.PostsResponsePojo;
import models.response.users.UsersResponsePojo;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostsApi extends BaseService {

    private static Response response = null;
    private static Logger logger = LoggerFactory.getLogger(PostsApi.class);
    private int userId = 0;
    private PostsResponsePojo[] postsResponsePojo;
    public static List postIdList;


    @When("posts api is invoked for username {string}")
    public void postsApiIsInvokedForUsername(String userName) {
        String endPoint = properties.getProperty("postsApiEndpoint");
        userId = UsersApi.userId;
        logger.info("Invoking Posts API for userName:" + userName + " whose userId is:" + userId);
        HashMap queryParams = new HashMap();
        queryParams.put("userId",userId);
        response = restDriver.getRequest(endPoint,queryParams);
    }

    @And("postId retrieval should be successful for username {string}")
    public void responsePostsIdRetrieval(String userName) {
        postsResponsePojo = response.getBody().as(PostsResponsePojo[].class);
        postIdList = new ArrayList();


        switch (UsersApi.userNameFoundStatus){
            case 1:
                Assert.assertTrue(postsResponsePojo.length > 0);
                logger.info("Number of Posts for userName:" + userName + " is :" + postsResponsePojo.length);
                for(PostsResponsePojo ele:postsResponsePojo){
                    int userId = ele.getUserId();
                    Assert.assertEquals(UsersApi.userId,userId);
                    int postId = ele.getId();
                    postIdList.add(postId);
                }
                logger.info("For user ID:" + UsersApi.userId + "; Here are the Post Ids:" + postIdList );
                break;
            case 0:
                Assert.assertTrue(postsResponsePojo.length == 0);
                break;
        }
    }

    @And("post ids are retrieved for username {string}")
    public void postIdsAreRetrievedForUsername(String userName) {
        postsApiIsInvokedForUsername(userName);
        responsePostsIdRetrieval(userName);
    }
}
