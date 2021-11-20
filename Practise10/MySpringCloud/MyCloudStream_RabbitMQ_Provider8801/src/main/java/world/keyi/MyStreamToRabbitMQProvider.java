package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月27日20:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyStreamToRabbitMQProvider {
    public static void main(String[] args) {
        SpringApplication.run(MyStreamToRabbitMQProvider.class,args);
    }
}
