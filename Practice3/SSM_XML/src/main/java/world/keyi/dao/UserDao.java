package world.keyi.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import world.keyi.domain.User;

import java.util.List;

//@Repository
public interface UserDao {
    List<User> findAllUser();
    User findUserByUsernameAndEmail(@Param("username") String username,@Param("email") String email);
}
