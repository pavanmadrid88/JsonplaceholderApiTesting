package Utils;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Properties;

public class RestDriver {

    RequestSpecBuilder requestSpecBuilder;
    RequestSpecification requestSpecification;

    public RestDriver(Properties properties){

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri(properties.getProperty("baseUrl"));
        requestSpecification = requestSpecBuilder.build();

    }

    /**
     * This method makes a get request for the endpoint specified
     * @param endpoint - get request endPoint
     * @return - response object of get request
     */
    public  Response getRequest(String endpoint){
        return RestAssured.given().spec(requestSpecification).log().all().get(endpoint);
    }

    /**
     * This method makes a get request with specified query parameters for the endpoint specified
     * @param endpoint - get request endPoint
     * @param queryParams - get request query parameters
     * @return - response object of get request
     */
    public  Response getRequest(String endpoint, HashMap queryParams){
        return RestAssured.given().spec(requestSpecification).log().all().queryParams(queryParams).get(endpoint);
    }

    /**
     * This method makes a get request with specified query parameters and path parameters for the endpoint specified
     * @param endpoint - get request endPoint
     * @param queryParams - get request query parameters
     * @param pathParams - get request path parameters
     * @return - response object of get request
     */
    public  Response getRequest(String endpoint, HashMap queryParams,HashMap pathParams){
        return RestAssured.given().spec(requestSpecification).log().all().queryParams(queryParams).pathParams(pathParams).get(endpoint);
    }



    /**
     * This method makes a get request with specified query parameters and path parameters for the endpoint specified
     * @param endpoint - GET request endPoint
     * @param queryParams - GET request query parameters
     * @param pathParams - GET request path parameters
     * @param cookies  - GET request cookies
     * @return - response object of GET request
     */
    public  Response getRequest(String endpoint, HashMap queryParams,HashMap pathParams,HashMap cookies){
        return RestAssured.given().spec(requestSpecification).log().all().queryParams(queryParams).pathParams(pathParams).cookies(cookies).get(endpoint);
    }


    /**
     * This method makes a POST request with specified requestBody for the endpoint specified
     * @param endpoint - POST request endPoint
     * @param requestBody - POST request body
     * @return - response object of POST request
     */
    public  Response postRequest(String endpoint,String requestBody){
        return RestAssured.given().spec(requestSpecification).body(requestBody).log().all().post(endpoint);
    }




}
