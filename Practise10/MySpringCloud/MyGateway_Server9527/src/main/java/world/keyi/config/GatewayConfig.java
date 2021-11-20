package world.keyi.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 万一
 * @date 2021年10月26日22:04
 */
@Configuration
public class GatewayConfig {
    /*
    * 网关的配置可以通过编码方式，也可以通过配置application.xml方式，这里是通过编码方式
    * */

    @Bean
    public RouteLocator toBlog(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("keyi.world",r->{
            //这里有问题，网关只是替换了域名和端口，但是后面路径不替换，因为我博客后没有/keyi路径，所以404
            return r.path("/keyi").uri("http://www.keyi.world");
        });
        return routes.build();
    }
}
