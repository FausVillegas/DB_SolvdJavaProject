package main.java.com.solvd.database.services.designpatterns.mvc;

import main.java.com.solvd.database.Main;
import main.java.com.solvd.database.model.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhoneView {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public void printPhoneDetails(Phone phone){
        LOGGER.info(phone);
    }
}
