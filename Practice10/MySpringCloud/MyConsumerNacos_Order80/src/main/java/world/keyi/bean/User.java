package world.keyi.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 万一
 * @date 2021年10月21日23:47
 */
@Component
@Data
@ConfigurationProperties("user")
public class User {
    private String name;
    private Integer age;
}
