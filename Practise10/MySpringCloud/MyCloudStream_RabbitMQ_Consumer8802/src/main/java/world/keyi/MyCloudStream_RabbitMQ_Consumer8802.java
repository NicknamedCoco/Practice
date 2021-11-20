package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月27日22:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyCloudStream_RabbitMQ_Consumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(MyCloudStream_RabbitMQ_Consumer8802.class,args);
    }
}
