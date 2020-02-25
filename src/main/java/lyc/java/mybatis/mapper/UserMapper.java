package lyc.java.mybatis.mapper;

import lyc.java.mybatis.POJO.User;

public interface UserMapper {
    public User selectUser(int id) throws Exception;
}
