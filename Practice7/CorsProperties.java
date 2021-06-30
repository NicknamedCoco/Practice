package world.keyi.arsystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author 万一
 * @date 2021年06月29日23:28
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {
    private List<String> origin;
    private boolean credentials;
    private List<String> headers;
    private List<String> methods;
    private Long maxAge;
    private String path;
}
