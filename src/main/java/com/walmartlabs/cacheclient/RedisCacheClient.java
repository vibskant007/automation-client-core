package com.walmartlabs.cacheclient;

import redis.clients.jedis.Jedis;

public class RedisCacheClient {

    private static RedisCacheClient instance;
    private static Jedis jedis;

    private RedisCacheClient(String host,int port){
        jedis = new Jedis(host,port);
    }

    public static synchronized RedisCacheClient getInstance(String host,int port) {
        if(instance == null) {
            instance = new RedisCacheClient(host,port);
        }

        return instance;
    }

    public void setKey(String key,String value) {
        jedis.set(key,value);
    }

    public String getKey(String key) {
        return jedis.get(key);
    }

    //TODO other methods
    /**
     *
     */

}
