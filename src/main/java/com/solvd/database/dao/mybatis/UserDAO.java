package main.java.com.solvd.database.dao.mybatis;

import main.java.com.solvd.database.model.User;
import main.java.com.solvd.database.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserDAO implements IUserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static SqlSession sqlSession;
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;
    private static IUserDao userMapper;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            LOGGER.info(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Override
    public User getEntityById(int id) {
        userMapper = sqlSessionFactory.openSession().getMapper(IUserDao.class);
        User user = userMapper.getEntityById(id);
        return user;
    }

    @Override
    public void insertEntity(User user) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insertEntity", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(User o) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("updateEntity",o);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(int id) {
        userMapper = sqlSessionFactory.openSession().getMapper(IUserDao.class);
        userMapper.removeEntity(id);
    }

    @Override
    public List<User> getEntities() {
        userMapper = sqlSessionFactory.openSession().getMapper(IUserDao.class);
        List<User> list = userMapper.getEntities();
        return list;
    }
}
