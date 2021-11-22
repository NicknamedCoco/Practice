package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 万一
 * @date 2021年10月25日9:47
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MyConsumerFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerFeignOrder80.class,args);
    }
}
