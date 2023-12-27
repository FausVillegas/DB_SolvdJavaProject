package main.java.com.solvd.database.dao;

import main.java.com.solvd.database.model.ContactInformation;
import main.java.com.solvd.database.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IContactInformationDao extends IBaseDao<ContactInformation>{
    ContactInformation getEntityById(@Param("id")int id);
    void insertEntity(@Param("contactInformation")ContactInformation operatingSystem);
    void updateEntity(@Param("operatingSystem")ContactInformation operatingSystem);
    void removeEntity(@Param("id")int id);
    List<ContactInformation> getEntities();
    ContactInformation getEntityByUserId(@Param("userId")int userId);
}
