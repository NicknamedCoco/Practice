package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月19日18:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyConsumerConsulOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerConsulOrder80.class,args);
    }
}
