package main.java.com.solvd.database.dao.jdbc;

import main.java.com.solvd.database.ConnectionPool;
import main.java.com.solvd.database.dao.IOperatingSystemsDao;
import main.java.com.solvd.database.model.OperatingSystem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperatingSystemDAO implements IOperatingSystemsDao {
    private static final Logger LOGGER = LogManager.getLogger(OperatingSystemDAO.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public OperatingSystem getEntityById(int id) {
        OperatingSystem operatingSystem = new OperatingSystem();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from operating_systems where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                operatingSystem.setName(resultSet.getString("name"));
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,resultSet);
        }
        return operatingSystem;
    }

    @Override
    public void insertEntity(OperatingSystem o) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into operating_systems (`name`) value (?)");
            preparedStatement.setString(1, o.getName());
            preparedStatement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,null);
        }
    }

    @Override
    public void updateEntity(OperatingSystem o) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update operating_systems set name=? where id=?");
            preparedStatement.setString(1, o.getName());
            preparedStatement.setInt(2, o.getId());
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
            preparedStatement = connection.prepareStatement("Delete from operating_systems where id=?");
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
    public List<OperatingSystem> getEntities() {
        List<OperatingSystem> list = new ArrayList<>();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from operating_systems");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                OperatingSystem operatingSystem = new OperatingSystem();
                operatingSystem.setName(resultSet.getString("name"));
                list.add(operatingSystem);
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
