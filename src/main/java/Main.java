import lyc.java.mybatis.POJO.User;
import lyc.java.mybatis.dao.UserDao;
import lyc.java.mybatis.impl.UserDaoImpl;
import lyc.java.mybatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory是数据库连接池，sqlSession代表一次mysql会话连接
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /*************selectOne方式，不用接口编程，对应UserMapper_selectOne.xml配置文件**************/
/*        try {
            User user = sqlSession.selectOne("UserMapper_selectOne.selectUser", 1);
            System.out.println(user);
        } catch (Exception e){
            sqlSession.rollback();  // 回滚事务
        } finally {
            sqlSession.close();
        }*/

        /*************selectOne方式，引入dao层，impl层，使用接口编程，对应UserMapper_selectOne.xml配置文件**************/
/*        try {
            UserDao userDao = new UserDaoImpl(sqlSession);
            User user = userDao.selectUser(1);
            System.out.println(user);
        } catch (Exception e){
            sqlSession.rollback();  // 回滚事务
        } finally {
            sqlSession.close();
        }*/
        /*************getMapper方式的mybatis动态代理，只写接口和xml，对应UserMapper_getMapper.xml配置文件**************/
        /**
        实际开发常用
        1. 建立dao层或mapper层（文件夹）
        2. 在层下，只写interface，n个interface，不用写实现类。
        3. n个xml映射文件对应n个dao层下的interface文件，namespace必须是全限定名，id和接口中的方法的名字一致。
        */
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUser(1);
            System.out.println(user);
        } catch (Exception e){
            sqlSession.rollback();  // 回滚事务
        } finally {
            sqlSession.close();
        }
    }
}
