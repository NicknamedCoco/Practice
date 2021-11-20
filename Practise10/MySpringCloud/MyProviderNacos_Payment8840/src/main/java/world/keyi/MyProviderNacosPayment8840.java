package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月21日14:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MyProviderNacosPayment8840 {
    public static void main(String[] args) {
        SpringApplication.run(MyProviderNacosPayment8840.class,args);
    }
}

