package main.java.com.solvd.database.dao;

import java.util.List;
import main.java.com.solvd.database.model.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao extends IBaseDao<User>{
    User getEntityById(@Param("id") int id);
    void insertEntity(@Param("user")User user);
    void updateEntity(@Param("user")User user);
    void removeEntity(@Param("id")int id);
    List<User> getEntities();
}
