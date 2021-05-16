package com.walmartlabs.context;

import java.util.HashMap;
import java.util.Map;

/*
 Class to store data between steps and pass onto next step!
*/
public class CucumberSteps {

    private Map<String,Object> context;

    public CucumberSteps() {
        context = new HashMap<>();
    }

    public void setData(String key,Object value){
        context.put(key,value);
    }

    public Object getData(String key) {
        return context.get(key);
    }

    public boolean hasData(String key) {
        return context.containsKey(key);
    }
}
