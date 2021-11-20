package world.keyi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import world.keyi.entities.CommonResult;
import world.keyi.entities.Payment;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年10月17日23:55
 */
@Slf4j
@RestController
@RequestMapping("/order/consul")
public class OrderController {

    public static final String PAYMENT_URL="http://MyProviderConsulPayment/payment/consul";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("")
    public String getPayment(){
       return  restTemplate.getForObject(PAYMENT_URL,String.class);
    }


}
