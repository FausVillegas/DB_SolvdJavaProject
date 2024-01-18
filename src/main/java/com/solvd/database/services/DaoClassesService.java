package main.java.com.solvd.database.services;

import main.java.com.solvd.database.dao.IBaseDao;
import main.java.com.solvd.database.services.designpatterns.factories.AbstractDaoClassesFactory;
import main.java.com.solvd.database.services.designpatterns.factories.classfactories.IClassFactory;

public class DaoClassesService {
    private IBaseDao objDao;
    public DaoClassesService(String type, String obj) {
        IClassFactory factory = AbstractDaoClassesFactory.createFactory(obj);
        objDao = factory.createDao(type);
    }

    public IBaseDao getObjDao() {
        return objDao;
    }

    public void setObjDao(IBaseDao objDao) {
        this.objDao = objDao;
    }
}
