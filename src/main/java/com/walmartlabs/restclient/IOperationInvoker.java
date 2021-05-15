package com.walmartlabs.restclient;

import io.restassured.response.Response;

public class IOperationInvoker {

    private RestOperation restOperation;

    public void setRestOperation(RestOperation restOperation) {
        this.restOperation = restOperation;
    }

    public Response execute() {
       return restOperation.executeOperation();
    }
}
