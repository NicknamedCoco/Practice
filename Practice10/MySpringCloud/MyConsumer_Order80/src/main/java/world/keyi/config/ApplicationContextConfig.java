package world.keyi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 万一
 * @date 2021年10月18日0:05
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   //使得请求可以被负载均衡，配置后，请求的接口，应该是服务端的项目名称，例如：MyProviderPayment，这就是Ribbon的负载均衡的功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
