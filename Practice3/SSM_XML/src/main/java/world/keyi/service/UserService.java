package world.keyi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.keyi.dao.UserDao;
import world.keyi.domain.User;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    public UserService() {
        System.out.println("UserService创建了");
    }

    @Resource
    private UserDao userDaoImpl;

    @Transactional
    public List<User> findAllUser() {
        List<User> users = userDaoImpl.findAllUser();
        return users;
    }

    public User findUserByUsernameAndEmail(String username,String email){
        User user = userDaoImpl.findUserByUsernameAndEmail(username, email);
        return user;
    }
}
