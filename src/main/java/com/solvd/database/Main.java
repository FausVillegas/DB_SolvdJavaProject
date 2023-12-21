package main.java.com.solvd.database;

import com.solvd.database.model.User;
import main.java.com.solvd.database.dao.IUserDao;
import main.java.com.solvd.database.dao.jdbc.ContactInformationDAO;
import main.java.com.solvd.database.dao.jdbc.OperatingSystemDAO;
import main.java.com.solvd.database.dao.jdbc.UserDAO;
import main.java.com.solvd.database.services.PrintService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static String getFramework(){
        Properties properties = new Properties();
        try (FileInputStream f = new FileInputStream("src/main/resources/config.properties")){
            properties.load(f);
        } catch (IOException e){
            LOGGER.error(e);
        }
        return properties.getProperty("framework");
    }
    public static void main(String[] args) {
        PrintService printService = new PrintService();
        printService.usersList();
        printService.contactInformationList();
        printService.operatingSystemsList();
    }
}