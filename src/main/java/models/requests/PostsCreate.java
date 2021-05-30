package models.requests;

public class PostsCreate {

    String title;
    String body;
    Integer userId;

    public  PostsCreate(){

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
