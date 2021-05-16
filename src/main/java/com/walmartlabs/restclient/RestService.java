package com.walmartlabs.restclient;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestService {

    private Map<String,Object> requestHeaderMap;
    private Map<String,Object> queryMap;

    public RestService(String baseUri,String basePath,Map<String,Object> headerMap,Map<String,Object> queryMap) {
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePath;
        this.requestHeaderMap = headerMap;
        this.queryMap = queryMap;
    }

    public Response doGet(String path) {
        if(requestHeaderMap!=null)
            return RestAssured.given().headers(requestHeaderMap).when().get(path);

        else if(requestHeaderMap!=null && queryMap!=null)
            return RestAssured.given().headers(requestHeaderMap).queryParams(queryMap).when().get(path);

        else
            return RestAssured.given().when().get(path);
    }

    public Response doPost(String path,Object body) {
        if(requestHeaderMap!=null)
            return RestAssured.given().headers(requestHeaderMap).body(body).post(path);

        else if(requestHeaderMap!=null && queryMap!=null)
            return RestAssured.given().headers(requestHeaderMap).queryParams(queryMap).body(body).post(path);

        else
            return RestAssured.given().when().body(body).post(path);
    }
}
