package world.keyi.springboot_initialization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringBootInitializationApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootInitializationApplication.class, args);
    }
}
