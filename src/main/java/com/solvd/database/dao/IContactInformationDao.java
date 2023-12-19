package main.java.com.solvd.database.dao;

import main.java.com.solvd.database.model.ContactInformation;
import com.solvd.database.model.User;

import java.util.List;

public interface IContactInformationDao extends IBaseDao<ContactInformation>{
    ContactInformation getEntityById(int id);
    void insertEntity(ContactInformation t);
    void updateEntity(ContactInformation t, int id);
    void removeEntity(int id);
    List<ContactInformation> getEntities();
    ContactInformation getEntityByUserId(int userId);
}
