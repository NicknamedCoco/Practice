package world.keyi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.keyi.feign.fallback.AccountServiceFallback;
import world.keyi.feign.interceptor.FeignInterceptor;
import world.keyi.result.CommonResult;



@FeignClient(value = "AccountService"
        /*,configuration = FeignInterceptor.class*/             //用于传递xid的配置，对seata无影响，暂时还不知道作用
        /*,fallbackFactory = AccountServiceFallback.class*/     //异常处理对seata有影响
)
@RequestMapping("/account")
public interface AccountServiceFeign {
    @PutMapping("/")
    public CommonResult<Integer> reduceAccount(@RequestParam("userId") String userId, @RequestParam("money") String money);
}
