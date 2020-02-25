package lyc.java.mybatis.dao;

import lyc.java.mybatis.POJO.User;

public interface UserDao {
    public User selectUser(int id);
    /*public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);*/
}
