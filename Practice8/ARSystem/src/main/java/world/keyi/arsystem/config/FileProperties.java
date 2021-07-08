package world.keyi.arsystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 万一
 * @date 2021年07月04日19:15
 *
 * 文件上传资源绑定
 */
@Data
@Configuration
@ConfigurationProperties("file")
public class FileProperties {

    /**
     * 文件保存的本地前缀，完整本地(真实)路径=本地前缀+时间目录+随机文件名+文件类型后缀，
     */
    private String localPath;

    /**
     * 请求路径前缀，完整请求路径=请求前缀+时间目录+随机文件名+文件类型后缀，
     */
    private String requestPath;

    /**
     * 图片路径，未完待续
     */
    private String imagePath;

}
