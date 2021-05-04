package world.keyi.springboot_initialization.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author 万一
 * @date 2021年05月02日14:44
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
        BCryptPasswordEncoder加密
    */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /*
    *  配置用户名，密码
    * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //这里的配置会覆盖properties配置文件中配置的账号密码
        auth.inMemoryAuthentication().withUser("万一")
                .password("$2a$10$6OrwgCJE2RcHGdikIQS4yewYtTj5tKl2.esWzkMvG9vKF8S5mcU4y").roles("admin")
                .and().withUser("一万")
                .password("$2a$10$6OrwgCJE2RcHGdikIQS4yewYtTj5tKl2.esWzkMvG9vKF8S5mcU4y").roles("user");
        // 配置多个使用and连接，一个就不用加and()
    }
}
