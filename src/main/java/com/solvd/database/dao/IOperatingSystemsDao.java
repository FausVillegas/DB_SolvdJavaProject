package main.java.com.solvd.database.dao;

import main.java.com.solvd.database.model.OperatingSystem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOperatingSystemsDao extends IBaseDao<OperatingSystem> {
    OperatingSystem getEntityById(@Param("id")int id);
    void insertEntity(@Param("operatingSystem")OperatingSystem operatingSystem);
    void updateEntity(@Param("operatingSystem")OperatingSystem operatingSystem);
    void removeEntity(@Param("id")int id);
    List<OperatingSystem> getEntities();
}
