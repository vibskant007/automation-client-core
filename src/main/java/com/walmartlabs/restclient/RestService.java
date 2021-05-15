package com.walmartlabs.restclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestService {

    private String baseUri;
    private String basePath;
    private Map<String,Object> requestHeaderMap;
    private Map<String,Object> queryMap;

    public RestService(String baseUri,String basePath,Map<String,Object> headerMap,Map<String,Object> queryMap) {
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePath;
        this.requestHeaderMap = headerMap;
        this.queryMap = queryMap;
    }

    public Response doGet(String path) {
        Response response = RestAssured.given().when().get(path);
        return response;
    }

    public Response doPost(String path,Object body) {
        Response response = RestAssured.given().headers(requestHeaderMap).body(body).post(path);
        return response;
    }
}
