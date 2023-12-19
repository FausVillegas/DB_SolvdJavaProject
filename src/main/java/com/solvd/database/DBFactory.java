package main.java.com.solvd.database;

import main.java.com.solvd.database.dao.IUserDao;

public class DBFactory {
    public static IUserDao getUserDAO(String tool){
        return switch (tool) {
            case "jdbc" -> new main.java.com.solvd.database.dao.jdbc.UserDAO();
            case "mybatis" -> new main.java.com.solvd.database.dao.mybatis.UserDAO();
            default -> null;
        };
    }
}
