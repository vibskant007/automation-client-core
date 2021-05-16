package com.walmartlabs.readers;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();

    private static ConfigReader configReader = new ConfigReader();

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public  ConfigReader getConfigReader() {
        return configReader;
    }

}
