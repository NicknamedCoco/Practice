package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年10月21日14:31
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MyConsumerNacosOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerNacosOrder80.class,args);
    }
}
