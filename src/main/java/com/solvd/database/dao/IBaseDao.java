package main.java.com.solvd.database.dao;

import java.util.List;

public interface IBaseDao<T> {
    T getEntityById(int id);
    void insertEntity(T t);
    void updateEntity(T t);
    void removeEntity(int id);
    List<T> getEntities();
}
