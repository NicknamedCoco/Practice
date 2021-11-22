package world.keyi.feign.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import world.keyi.feign.AccountServiceFeign;
import world.keyi.result.CommonResult;

/**
 * @author 万一
 * @DATE 2021年11月16日16:42
 */
@Component
@Slf4j
public class AccountServiceFallback  implements FallbackFactory<AccountServiceFeign> {
    @Override
    public AccountServiceFeign create(final Throwable throwable) {
        return new AccountServiceFeign() {
            @Override
            public CommonResult<Integer> reduceAccount(String userId, String money) {
                log.info("AccountServiceFeign报错："+throwable.getMessage());
                return new CommonResult<>(500,"error:"+throwable.getMessage(),0);
            }
        };
    }
}
