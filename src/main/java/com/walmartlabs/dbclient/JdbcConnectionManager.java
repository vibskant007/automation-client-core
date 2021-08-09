package com.walmartlabs.dbclient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionManager  {

    private static Logger logger = LoggerFactory.getLogger(JdbcConnectionManager.class);
    private static JdbcConnectionManager instance;
    private Connection connection;
    //TODO Load from config classes
    public static final String username = "";
    public static final String password = "";
    public static final String url = "";

    private JdbcConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            logger.error("Unable to connect to database ", e.getMessage());
        }
    }

    /**
     *
     * @return
     */
    private Connection getConnection(){
        return connection;
    }

    /**
     *
     * @return
     */

    public static JdbcConnectionManager getJdbcConnectionManager() {
      if(instance == null) {
          instance = new JdbcConnectionManager();
      }
      return instance;
    }


    public void close() throws Exception {
        connection.close();
    }
}
