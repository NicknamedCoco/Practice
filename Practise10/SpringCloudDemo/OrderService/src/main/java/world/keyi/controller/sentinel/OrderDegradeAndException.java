package world.keyi.controller.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import world.keyi.bean.Order;
import world.keyi.result.CommonResult;

/**
 * @author 万一
 * @DATE 2021年11月16日16:54
 */
@Slf4j
@Component
public class OrderDegradeAndException {
    //对指定方法配置熔断降级方法和异常处理方法
    public static CommonResult<Integer> create_degrade(@RequestBody Order order, BlockException exception){
        log.info("OrderController--create方法被熔断限流："+exception.getMessage());
        return new CommonResult<>(500,"error:"+exception.getMessage(),0);
    }
    public static CommonResult<Integer> create_exception(@RequestBody Order order, Throwable throwable){
        log.info("OrderController--create方法出现异常："+throwable.getMessage());
        return new CommonResult<>(500,"error:"+throwable.getMessage(),0);
    }

    public static String info_degrade(BlockException exception){
        log.info("OrderController--info方法被熔断限流："+exception.getStackTrace());
        return "info方法被熔断限流："+exception.getRule();
    }
    public static String info_exception(Throwable throwable){
        log.info("OrderController--info方法出现异常："+throwable.getMessage());
        return "info方法出现异常："+throwable.getMessage();
    }

    //全局异常处理
    public static CommonResult<Integer> global_exception(Throwable throwable){
        log.info("OrderController--create方法出现异常："+throwable.getMessage());
        return new CommonResult<>(500,"error:"+throwable.getMessage(),0);
    }
}
