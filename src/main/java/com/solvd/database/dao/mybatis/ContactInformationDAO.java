package main.java.com.solvd.database.dao.mybatis;

import main.java.com.solvd.database.dao.IContactInformationDao;
import main.java.com.solvd.database.dao.IOperatingSystemsDao;
import main.java.com.solvd.database.model.ContactInformation;
import main.java.com.solvd.database.model.OperatingSystem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ContactInformationDAO implements IContactInformationDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static SqlSession sqlSession;
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;
    private static IContactInformationDao contactInformationMapper;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            LOGGER.info(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Override
    public ContactInformation getEntityById(int id) {
        contactInformationMapper = sqlSessionFactory.openSession().getMapper(IContactInformationDao.class);
        ContactInformation contactInformation = contactInformationMapper.getEntityById(id);
        return contactInformation;
    }

    @Override
    public void insertEntity(ContactInformation contactInformation) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertEntity", contactInformation);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(ContactInformation contactInformation) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateEntity",contactInformation);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(int id) {
        contactInformationMapper = sqlSessionFactory.openSession().getMapper(IContactInformationDao.class);
        contactInformationMapper.removeEntity(id);
    }

    @Override
    public List<ContactInformation> getEntities() {
        contactInformationMapper = sqlSessionFactory.openSession().getMapper(IContactInformationDao.class);
        List<ContactInformation> list = contactInformationMapper.getEntities();
        return list;
    }

    @Override
    public ContactInformation getEntityByUserId(int userId) {
        contactInformationMapper = sqlSessionFactory.openSession().getMapper(IContactInformationDao.class);
        ContactInformation contactInformation = contactInformationMapper.getEntityByUserId(userId);
        return contactInformation;
    }
}
