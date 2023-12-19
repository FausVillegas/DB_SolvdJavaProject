package main.java.com.solvd.database.dao;

import java.util.List;
import com.solvd.database.model.User;

public interface IUserDao extends IBaseDao<User>{
    User getEntityById(int id);
    void insertEntity(User t);
    void updateEntity(User t, int id);
    void removeEntity(int id);
    List<User> getEntities();
}
