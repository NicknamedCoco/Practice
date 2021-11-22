package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月19日18:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyProviderConsulPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(MyProviderConsulPayment8006.class,args);
    }
}
