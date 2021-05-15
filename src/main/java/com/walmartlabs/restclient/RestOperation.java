package com.walmartlabs.restclient;

import io.restassured.response.Response;

public interface RestOperation {
    public Response executeOperation();
}
