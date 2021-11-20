package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月27日22:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyCloudStream_RabbitMQ_Consumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(MyCloudStream_RabbitMQ_Consumer8803.class,args);
    }
}
