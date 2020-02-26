package lyc.java.mybatis.dao;

import lyc.java.mybatis.POJO.User;

public interface UserMapper {
    public User selectUser(int id) throws Exception;
    public User selectUserByName(String name) throws Exception;
    public int insertUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public void deleteUser(int id) throws Exception;
}
