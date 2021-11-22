package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author 万一
 * @date 2021年10月25日15:46
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class MyProviderHystrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(MyProviderHystrixPayment8001.class,args);
    }
}
