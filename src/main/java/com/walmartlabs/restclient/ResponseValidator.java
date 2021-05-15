package com.walmartlabs.restclient;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ResponseValidator{

    private Response response;

    ResponseValidator(Response response) {
        this.response = response;
    }

    public void getStatus(int status) {
         response.then().statusCode(status);
    }

    public String getValue(String key) {
       return response.getBody().jsonPath().get(key);
    }

    public void subStringValidation(String substring) {
        response.then().body(containsString(substring));
    }

    public  void validateJsonKeyWithValue(String jsonKey,String jsonValue) {
        response.then().body(jsonKey,equalTo(jsonValue));
    }

    public void validateSchema(String path) {
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
    }

}
