package com.walmartlabs.restclient;

import io.restassured.response.Response;

public class PostOperation implements RestOperation {
    private RestService restService;
    private String path;
    private Object requestBody;

    public PostOperation(RestService restService,String path,Object requestBody) {
        this.restService = restService;
        this.path = path;
        this.requestBody = requestBody;
    }


    @Override
    public Response executeOperation() {
        return restService.doPost(this.path,this.requestBody);
    }
}
