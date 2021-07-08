package world.keyi.arsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "world.keyi.arsystem.mapper")
@SpringBootApplication
public class ArSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArSystemApplication.class, args);
    }

}
