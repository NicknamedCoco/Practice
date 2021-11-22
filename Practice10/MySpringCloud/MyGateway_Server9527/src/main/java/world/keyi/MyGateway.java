package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author 万一
 * @date 2021年10月26日21:34
 */
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class MyGateway {
    public static void main(String[] args) {
        SpringApplication.run(MyGateway.class,args);
    }
}
