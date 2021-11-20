package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 万一
 * @date 2021年10月17日20:03
 */
@SpringBootApplication
@EnableEurekaClient
public class MyProviderPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(MyProviderPayment8002.class,args);
    }
}
