package main.java.com.solvd.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.SessionFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import main.java.com.solvd.database.dao.IContactInformationDao;
import main.java.com.solvd.database.dao.IOperatingSystemsDao;
import main.java.com.solvd.database.model.*;
import main.java.com.solvd.database.dao.IUserDao;
import main.java.com.solvd.database.dao.jdbc.ContactInformationDAO;
import main.java.com.solvd.database.dao.jdbc.OperatingSystemDAO;
import main.java.com.solvd.database.dao.jdbc.UserDAO;
import main.java.com.solvd.database.services.Adapter.XmlDateAdapter;
import main.java.com.solvd.database.services.PrintService;
import main.java.com.solvd.database.services.dom.DomParser;
import main.java.com.solvd.database.services.jaxb.JaxB;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
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

        // -------------XML-------------
        //DOM
//        LOGGER.info("-----------DOM-----------");
//        DomParser.usersXml();

        //Jaxb
        LOGGER.info("-----------JAXB-----------");
        File xmlFile = new File("src/main/resources/users.xml");
        File jsonFile = new File("src/main/resources/users.json");

//        try {
//            JAXBContext context = JAXBContext.newInstance(Users.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            Users users = (Users) unmarshaller.unmarshal(file);
//            LOGGER.info("");
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }


        Users users = new Users();


//        user.setId(3);
//        user.setFirstName("Manuel");
//        user.setLastName("Lopez");
//        user.setAge(24);
//        Date date = new Date(2011, Calendar.MAY,1,0,0);
//        user.setHireDate(date);

        Date date = new Date(2011, Calendar.MAY,1,0,0);
        Phone phone = new Phone(1,"Samsung","S23",new OperatingSystem("Android 13",1),new Battery(1,5500));
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);
        User user = new User(3,"Manuel","Lopez",24,date,new ContactInformation("manuellopez@gmail.com",2222222L,3,1),phoneList);
        List<User> usersList = new ArrayList<>();
        usersList.add(user);
        users.setUsers(usersList);

//        try {
//            JaxB.marshall(users,xmlFile);
//            LOGGER.info(JaxB.unmarshal(xmlFile));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

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