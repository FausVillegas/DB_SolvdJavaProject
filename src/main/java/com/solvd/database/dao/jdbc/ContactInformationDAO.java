package main.java.com.solvd.database.dao.jdbc;

import com.solvd.database.model.User;
import main.java.com.solvd.database.ConnectionPool;
import main.java.com.solvd.database.dao.IContactInformationDao;
import main.java.com.solvd.database.model.ContactInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactInformationDAO implements IContactInformationDao {
    private static final Logger LOGGER = LogManager.getLogger(ContactInformationDAO.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public ContactInformation getEntityById(int id) {
        ContactInformation contactInformation = new ContactInformation();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from contact_information where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                contactInformation.setEmail(resultSet.getString("email"));
                contactInformation.setPhoneNumber(resultSet.getLong("phone_number"));
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,resultSet);
        }
        return contactInformation;
    }

    @Override
    public void insertEntity(ContactInformation o) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into contact_information (`email`,`phone_number`,`users_id`) value (?,?,?)");
            preparedStatement.setString(1, o.getEmail());
            preparedStatement.setLong(2, o.getPhoneNumber());
            preparedStatement.setInt(3, o.getUserId());
            preparedStatement.execute();
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,null);
        }
    }

    @Override
    public void updateEntity(ContactInformation o, int id) {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Update contact_information set email=?,phone_number=?,users_id=? where id=?");
            preparedStatement.setString(1, o.getEmail());
            preparedStatement.setLong(2, o.getPhoneNumber());
            preparedStatement.setInt(3, o.getUserId());
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
            preparedStatement = connection.prepareStatement("Delete from contact_information where id=?");
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
    public List<ContactInformation> getEntities() {
        List<ContactInformation> list = new ArrayList<>();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from contact_information");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                ContactInformation contactInformation = new ContactInformation();
                contactInformation.setEmail(resultSet.getString("email"));
                contactInformation.setPhoneNumber(resultSet.getLong("phone_number"));
                contactInformation.setUserId(resultSet.getInt("users_id"));
                list.add(contactInformation);
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public ContactInformation getEntityByUserId(int userId){
        ContactInformation contactInformation = new ContactInformation();
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * from contact_information where users_id=?");
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                contactInformation.setEmail(resultSet.getString("email"));
                contactInformation.setPhoneNumber(resultSet.getLong("phone_number"));
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }finally {
            connectionPool.putBack(connection);
            closeAll(preparedStatement,resultSet);
        }
        return contactInformation;
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
