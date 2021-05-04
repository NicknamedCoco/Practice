package world.keyi.springboot_initialization.config.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 万一
 * @date 2021年04月30日13:32
 */
//@Component
public class MyProxyAutoConfiguration {
    /*配置AOP切面*/
    @Bean
    public UserProxy userProxy(){
        return new UserProxy();
    }
}
