package main.java.com.solvd.database;

import com.mysql.cj.xdevapi.SessionFactory;
import main.java.com.solvd.database.dao.IContactInformationDao;
import main.java.com.solvd.database.dao.IOperatingSystemsDao;
import main.java.com.solvd.database.model.ContactInformation;
import main.java.com.solvd.database.model.OperatingSystem;
import main.java.com.solvd.database.model.User;
import main.java.com.solvd.database.dao.IUserDao;
import main.java.com.solvd.database.dao.jdbc.ContactInformationDAO;
import main.java.com.solvd.database.dao.jdbc.OperatingSystemDAO;
import main.java.com.solvd.database.dao.jdbc.UserDAO;
import main.java.com.solvd.database.services.PrintService;
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
        try(InputStream is = Resources.getResourceAsStream("mybatis-config.xml")){

            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);

            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);

            IOperatingSystemsDao iOperatingSystemsDao = sqlSession.getMapper(IOperatingSystemsDao.class);

            IContactInformationDao iContactInformationDao = sqlSession.getMapper(IContactInformationDao.class);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}