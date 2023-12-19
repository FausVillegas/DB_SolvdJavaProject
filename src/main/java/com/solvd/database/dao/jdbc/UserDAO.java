package main.java.com.solvd.database.dao.jdbc;

import com.solvd.database.model.User;
import main.java.com.solvd.database.ConnectionPool;
import main.java.com.solvd.database.dao.IBaseDao;
import main.java.com.solvd.database.dao.IUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public User getEntityById(int id) {
        User user = new User();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from users where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                user.setFirstName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,resultSet);
        }
        return user;
    }

    @Override
    public void insertEntity(User o) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into users (`name`,`last_name`,`age`) value (?,?,?)");
            preparedStatement.setString(1, o.getFirstName());
            preparedStatement.setString(2, o.getLastName());
            preparedStatement.setInt(3, o.getAge());
            preparedStatement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,null);
        }
    }

    @Override
    public void updateEntity(User o, int id) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update users set name=?,last_name=?,age=? where id=?");
            preparedStatement.setString(1, o.getFirstName());
            preparedStatement.setString(2, o.getLastName());
            preparedStatement.setInt(3, o.getAge());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,null);
        }
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Delete from users where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,null);
        }
    }

    @Override
    public List<User> getEntities() {
        List<User> list = new ArrayList<>();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from users");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                User user = new User();
                user.setFirstName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                list.add(user);
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,resultSet);
        }
        return list;
    }

    private void closeAll(PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(preparedStatement!=null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
