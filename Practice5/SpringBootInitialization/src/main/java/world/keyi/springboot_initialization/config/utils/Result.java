package world.keyi.springboot_initialization.config.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @date 2021年05月03日18:08
 * 工具类，封装数据返回给前端
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean flag;
    private String message;
    private Object data;
}
