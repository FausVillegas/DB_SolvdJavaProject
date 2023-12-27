package main.java.com.solvd.database.dao.mybatis;

import main.java.com.solvd.database.dao.IOperatingSystemsDao;
import main.java.com.solvd.database.dao.IUserDao;
import main.java.com.solvd.database.model.OperatingSystem;
import main.java.com.solvd.database.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OperatingSystemDAO implements IOperatingSystemsDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static SqlSession sqlSession;
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;
    private static IOperatingSystemsDao operatingSystemsMapper;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            LOGGER.info(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Override
    public OperatingSystem getEntityById(int id) {
        operatingSystemsMapper = sqlSessionFactory.openSession().getMapper(IOperatingSystemsDao.class);
        OperatingSystem operatingSystem = operatingSystemsMapper.getEntityById(id);
        return operatingSystem;
    }

    @Override
    public void insertEntity(OperatingSystem operatingSystem) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertEntity", operatingSystem);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(OperatingSystem operatingSystem) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateEntity",operatingSystem);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(int id) {
        operatingSystemsMapper = sqlSessionFactory.openSession().getMapper(IOperatingSystemsDao.class);
        operatingSystemsMapper.removeEntity(id);
    }

    @Override
    public List<OperatingSystem> getEntities() {
        operatingSystemsMapper = sqlSessionFactory.openSession().getMapper(IOperatingSystemsDao.class);
        List<OperatingSystem> list = operatingSystemsMapper.getEntities();
        return list;
    }
}
