package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 万一
 * @date 2021年10月18日17:10
 */
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServer7002.class,args);
    }
}
