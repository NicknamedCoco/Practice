package world.keyi.feign.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import world.keyi.feign.StorageServiceFeign;
import world.keyi.result.CommonResult;

/**
 * @author 万一
 * @DATE 2021年11月16日16:45
 */
@Component
@Slf4j
public class StorageServiceFallback implements FallbackFactory<StorageServiceFeign> {
    @Override
    public StorageServiceFeign create(final Throwable throwable) {
        return new StorageServiceFeign() {
            @Override
            public CommonResult<Integer> reduceStorage(String productId, String count) {
                log.info("StorageServiceFeign报错："+throwable.getMessage());
                return new CommonResult<>(500,"error："+throwable.getMessage(),0);
            }
        };
    }
}
