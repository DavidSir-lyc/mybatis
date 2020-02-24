package lyc.java.mybatis.mapper;

import lyc.java.mybatis.POJO.User;

public interface UserMapper {
    public User selectUserById(int id) throws Exception;
}
