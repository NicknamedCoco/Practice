package world.keyi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import world.keyi.entities.CommonResult;
import world.keyi.entities.Payment;

@Service
@FeignClient("MyProviderPayment")
public interface MyFeignWithPayment {
    @GetMapping("/payment/eureka/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id")Long id);
}
