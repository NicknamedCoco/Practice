package world.keyi.service;

import world.keyi.view.entity.User;

import java.util.List;

public interface UserService {
    String register(User user);
    Boolean login(User user);
    List<User> queryAllUser();
    Boolean query(String username);
}
