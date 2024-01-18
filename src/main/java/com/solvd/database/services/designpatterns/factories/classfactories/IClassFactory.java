package main.java.com.solvd.database.services.designpatterns.factories.classfactories;

import main.java.com.solvd.database.dao.IBaseDao;

public interface IClassFactory {
    IBaseDao createDao(String type);
}
