package main.java.com.solvd.database.services.designpatterns.proxy;

import java.sql.Connection;

public interface ConnectionPreparator {
    Connection getConnection();
}
