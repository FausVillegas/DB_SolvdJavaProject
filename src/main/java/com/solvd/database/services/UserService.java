package main.java.com.solvd.database.services;

import main.java.com.solvd.database.Main;
import main.java.com.solvd.database.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public void printUser(User user){
        LOGGER.info(user);
    }
}
