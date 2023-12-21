package main.java.com.solvd.database.services;

import main.java.com.solvd.database.DBFactory;
import main.java.com.solvd.database.dao.IUserDao;
import main.java.com.solvd.database.dao.jdbc.ContactInformationDAO;
import main.java.com.solvd.database.dao.jdbc.OperatingSystemDAO;
import main.java.com.solvd.database.dao.jdbc.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintService {
    private static final Logger LOGGER = LogManager.getLogger(PrintService.class);
    private UserDAO userDAO = new UserDAO();
    private ContactInformationDAO contactInformationDAO = new ContactInformationDAO();
    private OperatingSystemDAO operatingSystemDAO = new OperatingSystemDAO();

    public void usersList(){
        userDAO.getEntities().stream().forEach(LOGGER::info);
    }
    public void contactInformationList(){
        contactInformationDAO.getEntities().stream().forEach(LOGGER::info);
    }
    public void operatingSystemsList(){
        operatingSystemDAO.getEntities().stream().forEach(LOGGER::info);
    }
}
