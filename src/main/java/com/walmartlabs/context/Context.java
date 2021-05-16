package com.walmartlabs.context;

import com.walmartlabs.readers.FileReaderManager;
import com.walmartlabs.restclient.IOperationInvoker;
import com.walmartlabs.restclient.RestService;

/*
 Class to be used in dependency Injection!
*/
public class Context {

    private RestService restService;
    private IOperationInvoker iOperationInvoker;
    private CucumberSteps cucumberSteps;

    public Context() {
        restService = new RestService(FileReaderManager.getInstance().getConfigReader().getBaseEndpoint(),FileReaderManager.getInstance().getConfigReader().getBasePath(),FileReaderManager.getInstance().getConfigReader().getHeaderMap(),FileReaderManager.getInstance().getConfigReader().getQueryMap());
        iOperationInvoker = new IOperationInvoker();
        cucumberSteps = new CucumberSteps();
    }

    public RestService getRestService() {
        return restService;
    }

    public IOperationInvoker getIOperationInvoker() {
        return iOperationInvoker;
    }

    public CucumberSteps getCucumberSteps() {
        return cucumberSteps;
    }
}
