package com.walmartlabs.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
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

    public Map<String,Object> getHeaderMap() {
        Object mapString = properties.get("headerMap");
        return objectMapper.convertValue(mapString.toString(),Map.class);
    }

    public Map<String,Object> getQueryMap() {
        Object mapString = properties.get("queryMap");
        return objectMapper.convertValue(mapString.toString(),Map.class);
    }


}
