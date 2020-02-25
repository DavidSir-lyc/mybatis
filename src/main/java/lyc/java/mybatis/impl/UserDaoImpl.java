package lyc.java.mybatis.impl;

import lyc.java.mybatis.POJO.User;
import lyc.java.mybatis.dao.UserDao;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;
    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession  = sqlSession;
    }

    @Override
    public User selectUser(int id) {
        return this.sqlSession.selectOne("UserMapper_selectOne.selectUser", id);
    }
}
