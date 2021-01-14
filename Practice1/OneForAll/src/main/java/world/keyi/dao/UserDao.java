package world.keyi.dao;

import world.keyi.view.entity.User;

import java.util.List;

public interface UserDao {
    int addUser(User user);
    int deleteUser(String username);
    int updateUser(User user);
    List<User> queryAllUser();
    User queryUser(String username);
}
