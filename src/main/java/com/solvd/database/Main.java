package main.java.com.solvd.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import main.java.com.solvd.database.interfaces.IUserInfo;
import main.java.com.solvd.database.model.*;
import main.java.com.solvd.database.services.DaoClassesService;
import main.java.com.solvd.database.services.designpatterns.decorator.Administrator;
import main.java.com.solvd.database.services.designpatterns.decorator.Customer;
import main.java.com.solvd.database.services.designpatterns.listener.ListenersHolders;
import main.java.com.solvd.database.services.designpatterns.listener.UserListener;
import main.java.com.solvd.database.services.designpatterns.mvc.PhoneController;
import main.java.com.solvd.database.services.jaxb.JaxB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static String getFramework(){
        Properties properties = new Properties();
        try (FileInputStream f = new FileInputStream("src/main/resources/config.properties")){
            properties.load(f);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return properties.getProperty("framework");
    }
    public static void main(String[] args) {
//        try(InputStream is = Resources.getResourceAsStream("mybatis-config.xml")){
//
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
//                    .build(is);
//            SqlSession sqlSession = sessionFactory.openSession(true);
//
//            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
//
//            IOperatingSystemsDao iOperatingSystemsDao = sqlSession.getMapper(IOperatingSystemsDao.class);
//
//            IContactInformationDao iContactInformationDao = sqlSession.getMapper(IContactInformationDao.class);
//
//        }catch (IOException e){
//            throw new RuntimeException(e);
//        }
//
//        // -------------XML-------------
//        //DOM
//        LOGGER.info("-----------DOM-----------");
//        DomParser.usersXml();
//

//        //users to add to xml and json file
        Phone phone = new Phone(1,"Samsung","S23",new OperatingSystem("Android 13",1),new Battery(1,5500));
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);

        Users users = new Users();
        List<User> usersList = new ArrayList<>();

        User user = User.builder()
                .id(3)
                .firstName("Fausto")
                .lastName("Villegas")
                .age(23)
                .hireDate(new Date(2019, Calendar.MAY,1,0,0))
                .phoneList(phoneList)
                .contactInformation(new ContactInformation("faustovillegas@gmail.com",22222222L,3,1))
                .build();

        usersList.add(user);
        users.setUsers(usersList);

        //Jaxb
        LOGGER.info("-----------JAXB-----------");
        File xmlFile = new File("src/main/resources/users.xml");
        File jsonFile = new File("src/main/resources/users.json");

//        try {
//            JAXBContext context = JAXBContext.newInstance(Users.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            Users users1 = (Users) unmarshaller.unmarshal(xmlFile);
//            LOGGER.info("");
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }

        try {
            JaxB.marshall(users,xmlFile);
            LOGGER.info(JaxB.unmarshal(xmlFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //------------JSON-------------
        //Jackson
        LOGGER.info("-----------JACKSON-----------");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(jsonFile,users);
            Users usersJson = mapper.readValue(jsonFile, Users.class);
            LOGGER.info(usersJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}