package world.keyi.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 万一
 * @date 2021年10月25日15:52
 */
@Service
@Slf4j
public class PaymentServiceWithHystrix {

    /*正常的处理*/
    public String getPaymentInfo_OKTest(String id){
        return Thread.currentThread().getName()+" getPaymentInfo_OKTest,id:"+id;
    }

    /*处理时间长*/
    /*@HystrixCommand(fallbackMethod = "paymentInfo_timeoutOrError",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value ="3000")
    })*/
    public String getPaymentInfo_NotOKTest(String id){
        log.info("当前线程名："+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+" getPaymentInfo_NotOKTest,id:"+id;
    }

    /*当上面服务处理失败后(运行异常，超时异常)，回调下面的方法，进行兜底操作*/
    public String paymentInfo_timeoutOrError(String id){
        log.info(id);
        return "支付模块异常，当前线程名："+Thread.currentThread().getName();
    }

    //*******************************服务熔断*****************************************************
    //服务熔断指的是，如果短时间内有较多的方法被服务降级，则触发器状态，使得之后一定时间内，任何请求访问的都是降级方法
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数，默认10秒内大于20次请求则进行统计
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //统计的时间范围，注解不管用，可能需要配置在application.xml中
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸，10秒内fallback到60%
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }



}
