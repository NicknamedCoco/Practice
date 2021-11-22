package world.keyi.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import world.keyi.entities.CommonResult;
import world.keyi.entities.Payment;

@Service
@FeignClient(value = "MYPROVIDERHYSTRIXPAYMENT",fallback = GlobalWayForHystrix.class)
public interface MyFeignWithPayment {
    @GetMapping("/payment/eureka/hystrix/ok/{id}")
    public String getPaymentInfo_OKTest(@PathVariable("id")String id);


    @GetMapping("/payment/eureka/hystrix/timeout/{id}")
    public String getPaymentInfo_NotOKTest(@PathVariable("id")String id);


}
