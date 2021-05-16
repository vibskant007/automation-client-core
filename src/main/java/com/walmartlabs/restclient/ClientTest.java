package com.walmartlabs.restclient;

/*
 Main Class showing usage of rest template!
*/
public class ClientTest {
    public static void main(String[] args) {
        RestService restService = new RestService("https://jsonplaceholder.typicode.com/","/todos/",null,null);
        IOperationInvoker iOperationInvoker = new IOperationInvoker();
        iOperationInvoker.setRestOperation(new GetOperation(restService,"/1/"));
        System.out.println(iOperationInvoker.execute().asString());
    }
}
