package world.keyi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import world.keyi.bean.User;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年10月17日23:55
 */
@Slf4j
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    public static final String PAYMENT_URL="http://MyProviderNacosPayment/payment/nacos";

    @Resource
    private User user;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("")
    public String getPayment(){
       return  restTemplate.getForObject(PAYMENT_URL,String.class);
    }

    @GetMapping("/info")
    public void getInfo(){
        System.out.println(user);
    }

}
