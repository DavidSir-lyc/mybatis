import lyc.java.mybatis.POJO.User;
import lyc.java.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // 读取mybatis全局配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取sqlSession
        try {
            // selectOne(namespace.id, 指定传入sql的参数)
            User user = sqlSession.selectOne("UserMapper.selectUser", 1);
            System.out.println(user);
            // 编写一个mapper接口,不用实体类，而是接口动态代理生成类
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.selectUserById(1));
        } catch (Exception e){
            sqlSession.rollback();  // 回滚事务
        } finally {
            sqlSession.close();
        }
    }
}