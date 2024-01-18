package main.java.com.solvd.database.services.designpatterns.factories;

import main.java.com.solvd.database.dao.IContactInformationDao;
import main.java.com.solvd.database.dao.IOperatingSystemsDao;
import main.java.com.solvd.database.dao.IUserDao;

public class DaoClassesFactory {
    public static IUserDao createUserDao(String type) {
        IUserDao result;
        switch (type) {
            case "jdbc":
                result = new main.java.com.solvd.database.dao.jdbc.UserDAO();
                break;
            case "mybatis":
                result = new main.java.com.solvd.database.dao.mybatis.UserDAO();
                break;
            default:
                throw new RuntimeException(String.format("Unable to create an object related to the '%s' type", type));
        }
        return result;
    }

    public static IContactInformationDao createContactInformationDao(String type) {
        IContactInformationDao result;
        switch (type) {
            case "jdbc":
                result = new main.java.com.solvd.database.dao.jdbc.ContactInformationDAO();
                break;
            case "mybatis":
                result = new main.java.com.solvd.database.dao.mybatis.ContactInformationDAO();
                break;
            default:
                throw new RuntimeException(String.format("Unable to create an object related to the '%s' type", type));
        }
        return result;
    }

    public static IOperatingSystemsDao createOperatingSystemsDao(String type) {
        IOperatingSystemsDao result;
        switch (type) {
            case "jdbc":
                result = new main.java.com.solvd.database.dao.jdbc.OperatingSystemDAO();
                break;
            case "mybatis":
                result = new main.java.com.solvd.database.dao.mybatis.OperatingSystemDAO();
                break;
            default:
                throw new RuntimeException(String.format("Unable to create an object related to the '%s' type", type));
        }
        return result;
    }
}
