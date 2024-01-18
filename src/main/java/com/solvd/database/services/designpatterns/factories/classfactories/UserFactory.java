package main.java.com.solvd.database.services.designpatterns.factories.classfactories;

import main.java.com.solvd.database.dao.IBaseDao;
import main.java.com.solvd.database.dao.IUserDao;

public class UserFactory implements IClassFactory {
    @Override
    public IBaseDao createDao(String type) {
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
}
