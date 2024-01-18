package main.java.com.solvd.database.services.designpatterns.factories.classfactories;

import main.java.com.solvd.database.dao.IBaseDao;
import main.java.com.solvd.database.dao.IContactInformationDao;

public class ContactInformationFactory implements IClassFactory {
    @Override
    public IBaseDao createDao(String type) {
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
}
