package main.java.com.solvd.database;

import main.java.com.solvd.database.interfaces.IUserInfo;
import main.java.com.solvd.database.model.*;
import main.java.com.solvd.database.services.DaoClassesService;
import main.java.com.solvd.database.services.designpatterns.decorator.Administrator;
import main.java.com.solvd.database.services.designpatterns.decorator.Customer;
import main.java.com.solvd.database.services.designpatterns.listener.ListenersHolders;
import main.java.com.solvd.database.services.designpatterns.listener.UserListener;
import main.java.com.solvd.database.services.designpatterns.mvc.PhoneController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainDesignPatternsTest {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Phone phone = new Phone(1,"Samsung","S23",new OperatingSystem("Android 13",1),new Battery(1,5500));
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);

        User user = User.builder()
                .id(3)
                .firstName("Fausto")
                .lastName("Villegas")
                .age(23)
                .hireDate(new Date(2019, Calendar.MAY,1,0,0))
                .phoneList(phoneList)
                .contactInformation(new ContactInformation("faustovillegas@gmail.com",22222222L,3,1))
                .build();

        //------------Design patterns-------------

        //Factory
        DaoClassesService daoClassesService = new DaoClassesService(Main.getFramework(),"user");

        //Builder
        //in User Class

        //Listener
        ListenersHolders.subscribe(new UserListener());

        Users users = new Users();
        users.addUser(user);

        users.removeUser(user);

        //Strategy
        //setter in service

        //Decorator
        User user1 = User.builder()
                .firstName("Juan")
                .lastName("Lopez")
                .age(28)
                .build();
        User user2 = User.builder()
                .firstName("Matias")
                .lastName("Perez")
                .age(20)
                .build();
        LOGGER.info(user1.basicInformation());

        IUserInfo customer = new Customer(user1);
        IUserInfo administrator = new Administrator(user2);
        LOGGER.info(customer.basicInformation());
        LOGGER.info(administrator.basicInformation());

        //Proxy
        //(ConnectionProxy)

        //MVC
        PhoneController phoneController = new PhoneController(phone);
        phoneController.updateView();
        phoneController.setModel("S24");
        phoneController.updateView();
    }
}
