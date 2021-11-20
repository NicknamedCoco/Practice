package world.keyi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.service.PaymentServiceWithHystrix;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年10月25日16:11
 */
@RestController
@Slf4j
@RequestMapping("/payment/eureka/hystrix")
public class PaymentControllerWithHystrix {

    @Resource
    private PaymentServiceWithHystrix paymentServiceWithHystrix;

    /*调用正常的方法*/
    @GetMapping("/ok/{id}")
    public String getPaymentInfo_OKTest(@PathVariable("id")String id){
        String result = paymentServiceWithHystrix.getPaymentInfo_OKTest(id);
        log.info(result);
        return result;
    }

    /*
        经过测试，当并发量大的时候，尽管OKTest方法中没有调用paymentServiceWithHystrix.getPaymentInfo_NotOKTest
        但是请求处理速度也变慢了，因为tomcat的工作线程池中所有线程都被去处理NotOKTest方法的请求了，
    */

    /*调用等待三秒的方法*/
    @GetMapping("/timeout/{id}")
    public String getPaymentInfo_NotOKTest(@PathVariable("id")String id){
        String result = paymentServiceWithHystrix.getPaymentInfo_NotOKTest(id);
        log.info(result);
        return result;
    }


    //===服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentServiceWithHystrix.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }








}
