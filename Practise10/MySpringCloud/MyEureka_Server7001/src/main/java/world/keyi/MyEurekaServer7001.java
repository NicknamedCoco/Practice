package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 万一
 * @date 2021年10月18日13:20
 */
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServer7001 {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServer7001.class,args);
    }
}
