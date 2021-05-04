package world.keyi.springboot_initialization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import world.keyi.springboot_initialization.bean.PO.UserPO;
import world.keyi.springboot_initialization.service.UserService;

import java.util.Date;

@SpringBootTest
class SpringBootInitializationApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("654321");
        UserPO userPO = new UserPO("一万",encode,"one.dayinaug@gmail.com",new Date());
        System.out.println(passwordEncoder.matches("654321",encode));
        userService.save(userPO);
    }
}
