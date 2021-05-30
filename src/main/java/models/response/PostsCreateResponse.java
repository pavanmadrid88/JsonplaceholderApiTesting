package models.response;

public class PostsCreateResponse {

    Integer id;
    String title;
    String body;
    Integer userId;

    public PostsCreateResponse(Integer id, String title, String body, Integer userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public  PostsCreateResponse() {

    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getUserId() {
        return userId;
    }





}
