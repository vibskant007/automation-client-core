package com.walmartlabs.readers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String propFileName = "config.properties";

    public ConfigReader()  {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getBaseEndpoint() {
        return properties.getProperty("base.url");
    }

    public String getBasePath() {
        return properties.getProperty("base.path");
    }

    public HashMap<String,Object> getHeaderMap() throws JsonProcessingException {
        Object mapString = properties.get("headerMap");
        System.out.println(mapString.toString());
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};

        HashMap<String,Object> o = objectMapper.readValue(mapString.toString(), typeRef);
        return o;
    }

    public Map<String,Object> getQueryMap() throws JsonProcessingException {
        Object mapString = properties.get("queryMap");
        System.out.println(mapString.toString());
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};

        HashMap<String,Object> o = objectMapper.readValue(mapString.toString(), typeRef);
        return o;
    }




}
