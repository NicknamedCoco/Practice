package world.keyi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import world.keyi.entities.CommonResult;
import world.keyi.entities.Payment;
import world.keyi.lb.MyLoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author 万一
 * @date 2021年10月17日23:55
 */
@Slf4j
@RestController
@RequestMapping("/order/eureka")
public class OrderController {

    /*
        想使用服务名称发送请求，就必须开启@LoadBalanced注解
     */
    public static final String PAYMENT_URL="http://MYPROVIDERPAYMENT/payment/eureka/";

    @Resource
    MyLoadBalancer myLoadBalancer;

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        log.info("正在获取支付接口数据");
       return  restTemplate.getForObject(PAYMENT_URL+id,CommonResult.class);
    }

    @PostMapping("/")
    public CommonResult insert(@RequestBody Payment payment){
        log.info("正在存入订单数据");
        return restTemplate.postForObject(PAYMENT_URL,payment,CommonResult.class);
    }

    /*
        测试自定义负载均衡算法
     */
    @GetMapping("/lb")
    public String myLoadBalancer(){
        log.info("正在使用自己的负载均衡算法");
        List<ServiceInstance> myproviderpayment = discoveryClient.getInstances("MYPROVIDERPAYMENT");
        if (myproviderpayment==null||myproviderpayment.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalancer.selectInstance(myproviderpayment);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/eureka/lb",String.class);
    }

    /*
        zipkin+sleuth,服务链路追踪测试
     */
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/zipkin", String.class);
        return result;
    }
}
