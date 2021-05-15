package com.walmartlabs.restclient;

import io.restassured.response.Response;

public class GetOperation implements RestOperation{

    private RestService restService;
    private String path;

    public GetOperation(RestService restService,String path) {
        this.restService = restService;
        this.path = path;
    }

    @Override
    public Response executeOperation() {
        return restService.doGet(path);
    }
}
