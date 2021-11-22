package world.keyi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Objects;

/**
 * @author 万一
 * @date 2021年10月26日23:03
 */
@Component
@Order(-1)  //数字越小，优先级越高
@Slf4j
public class MyLogGatewayGlobalFilter implements GlobalFilter {
    /**
     * 自定义的网关过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********************进入自定义网关全局过滤器，time:"+new Date());
        String wanyi = exchange.getRequest().getQueryParams().getFirst("wanyi");
        if (Objects.isNull(wanyi)){
            log.info("wanyi为null，不允许进入系统");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);  //返回状态码401，表示未登录
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);  //请求放行，执行下一个过滤器
    }
}
