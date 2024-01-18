package main.java.com.solvd.database.services;

import main.java.com.solvd.database.Main;
import main.java.com.solvd.database.model.User;
import main.java.com.solvd.database.model.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsersService {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private UserService userService;
    public void printUsers(Users users){
        int i=1;
        for (User user : users.getUsers()) {
            LOGGER.info("User "+i);
            userService.printUser(user);
            i++;
        }
    }
}
