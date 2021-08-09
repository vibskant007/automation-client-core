package com.walmartlabs.dbclient;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoConnectionUtils {

	private static final Logger logger = LoggerFactory.getLogger(MongoConnectionUtils.class);

	private MongoClient mongoClient = null;

	/**
	 * create the mongo client connection
	 * 
	 * @return - mongo client 
	 */
	public MongoClient getMongoConnection(String host,int port) {
		try {
			if (mongoClient == null) {
				mongoClient = new MongoClient(host, port);

			}
		} catch (MongoException e) {
			logger.error("Unable to connect",e);
		}
		return mongoClient;
	}


	public void closeMongoClient() {
		try {
			if (mongoClient != null) {
				mongoClient.close();
			}
		} catch (MongoException e) {
			logger.error("Unable to close connection",e);
		}
	}


}