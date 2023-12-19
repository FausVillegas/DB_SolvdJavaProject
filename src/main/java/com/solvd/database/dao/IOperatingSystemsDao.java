package main.java.com.solvd.database.dao;

import main.java.com.solvd.database.model.OperatingSystem;

import java.util.List;

public interface IOperatingSystemsDao extends IBaseDao<OperatingSystem> {
    OperatingSystem getEntityById(int id);
    void insertEntity(OperatingSystem t);
    void updateEntity(OperatingSystem t, int id);
    void removeEntity(int id);
    List<OperatingSystem> getEntities();
}
