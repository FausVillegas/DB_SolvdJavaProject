package main.java.com.solvd.database.services.designpatterns.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator implements ConnectionPreparator{
    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
