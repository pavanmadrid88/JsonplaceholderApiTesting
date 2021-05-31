package models.requests;

public class PostsRequestPojo {

    String title;
    String body;
    Integer userId;

    public  PostsRequestPojo(){

    }
        

    public PostsRequestPojo(String title, String body, Integer userId) {		
		this.title = title;
		this.body = body;
		this.userId = userId;
	}


	public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }




}
