package world.keyi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.keyi.feign.fallback.StorageServiceFallback;
import world.keyi.feign.interceptor.FeignInterceptor;
import world.keyi.result.CommonResult;


@FeignClient(value = "StorageService"
        /*,configuration = FeignInterceptor.class*/
        /*,fallbackFactory = StorageServiceFallback.class*/
)
@RequestMapping("/storage")
public interface StorageServiceFeign {
    @PutMapping("/")
    public CommonResult<Integer> reduceStorage(@RequestParam("productId") String productId, @RequestParam("count") String count);
}
