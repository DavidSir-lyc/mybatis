import lyc.java.mybatis.POJO.User;
import lyc.java.mybatis.dao.UserDao;
import lyc.java.mybatis.impl.UserDaoImpl;
import lyc.java.mybatis.mapper.UserMapper;
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
        UserDao userDao = new UserDaoImpl(sqlSession);
        try {
            // selectOne(namespace.id, 指定传入sql的参数)
            User user = userDao.selectUser(2);
            System.out.println(user);


            // 编写一个mapper接口,不用实体类，而是接口动态代理生成类
/*            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.selectUserById(1));*/
        } catch (Exception e){
            sqlSession.rollback();  // 回滚事务
        } finally {
            sqlSession.close();
        }
    }
}
