package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 万一
 * @date 2021年11月08日19:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MySentinelService {
    public static void main(String[] args) {
        SpringApplication.run(MySentinelService.class,args);
    }
}
