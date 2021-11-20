package world.keyi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.entities.CommonResult;
import world.keyi.service.MyFeignWithPayment;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年10月25日9:58
 */
@RestController
@Slf4j
@RequestMapping("/order/feign/hystrix")
//@DefaultProperties(defaultFallback = "globalFallback")
public class MyFeignController {

    @Resource
    private MyFeignWithPayment myFeignWithPayment;

    @GetMapping("/ok/{id}")
//    @HystrixCommand //如果没有指定fallback，则走全局兜底方法，这样就无需每个业务方法都写个fallback方法
    public String getPaymentInfo_OKTest(@PathVariable("id")String id){
        System.out.println("执行order模块中的okTest方法");
        return myFeignWithPayment.getPaymentInfo_OKTest(id);
    }

    @GetMapping("/timeout/{id}")
    @HystrixCommand(fallbackMethod = "order_timeoutOrError",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value ="3000")
    })
    public String getPaymentInfo_NotOKTest(@PathVariable("id")String id){
        System.out.println("执行order模块中的notOKTest方法");
        String result = myFeignWithPayment.getPaymentInfo_NotOKTest(id);
        System.out.println(result);
        System.out.println("你是啥？"+result);
        return result;
    }

    /*当上面服务处理失败后(运行异常，超时异常)，回调下面的方法，进行兜底操作*/
    public String order_timeoutOrError(String id){
        log.info(id);
        return "订单接口异常，当前线程名："+Thread.currentThread().getName();
    }

    /*全局兜底方法，只要标注了@HystrixCommand注解，但没有指定fallback，就执行全局的兜底方法*/
    public String globalFallback(){
        log.info("进入全局的熔断方法");
        return "方法执行异常。。。。";
    }
}
