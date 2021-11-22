package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 万一
 * @date 2021年10月31日21:15
 */
@SpringBootApplication
public class MyRabbitMQConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MyRabbitMQConsumer.class,args);
    }
}
