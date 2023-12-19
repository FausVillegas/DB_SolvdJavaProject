package main.java.com.solvd.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static String url;
    private static String user;
    private static String password;
    private Vector<Connection> connectionPool = new Vector<>(INITIAL_POOL_SIZE);
    private Vector<Connection> usedConnections = new Stack<>();
    private static final int INITIAL_POOL_SIZE = 5;
    private static final Properties p = new Properties();
    private static ConnectionPool instance;

    private ConnectionPool() {
        for (int i = 0; i<INITIAL_POOL_SIZE; i++){
            Connection connection = null;
            try{
                connection = DriverManager.getConnection(url,user,password);
            } catch (SQLException e){
                LOGGER.info(e);
            }
            connectionPool.add(connection);
        }
    }

    public static ConnectionPool getInstance(){
        if(instance == null) instance = new ConnectionPool();
        return instance;
    }

    public static ConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionPool();
    }

    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        url = p.getProperty("db.url");
        user = p.getProperty("db.username");
        password = p.getProperty("db.password");
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            LOGGER.error(e);
        }
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public Connection retrieve() {
        // Check for an available connection
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("No connections available in the pool");
        }

        // Retrieve the last connection from the list
        Connection connection = connectionPool.get(connectionPool.size() - 1);
        connectionPool.remove(connectionPool.size() - 1);

        return connection;
    }
    public void putBack(Connection connection) {
        // Add the connection back to the pool
        connectionPool.add(connection);
    }
}