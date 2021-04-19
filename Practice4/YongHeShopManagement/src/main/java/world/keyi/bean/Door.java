package world.keyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

/**
 * @author 万一
 * @date 2021年04月19日10:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Configuration
public class Door {
    private Integer id;
    private String name;
    private String tel;
    private String addr;
}
