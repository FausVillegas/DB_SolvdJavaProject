package main.java.com.solvd.database.services.designpatterns.listener;

import main.java.com.solvd.database.Main;
import main.java.com.solvd.database.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserListener implements IUserListener{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    @Override
    public void onNewUser(User user) {
        LOGGER.info("Collect user info");
    }

    @Override
    public void onUserDeleted(User user) {
        LOGGER.info("Delete user info");
    }
}
