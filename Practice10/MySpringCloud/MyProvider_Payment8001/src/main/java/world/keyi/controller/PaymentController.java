package world.keyi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import world.keyi.entities.CommonResult;
import world.keyi.entities.Payment;
import world.keyi.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 万一
 * @date 2021年10月17日21:22
 */
@RestController
@Slf4j
@RequestMapping("/payment/eureka")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id")Long id){
        Payment payment = paymentService.queryById(id);
        log.info("查询结果是："+payment);
        //测试openfeign的超时控制
        /*log.info("测试openFeign超时等待，等待3秒");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (Objects.nonNull(payment)){
            return new CommonResult<>(200,"查询成功，访问的port:"+port,payment);
        }
        return new CommonResult<>(404,"查询失败",null);
    }

    @PostMapping("/")
    public CommonResult<Integer> insert(@RequestBody Payment payment){
        int result = paymentService.insert(payment);
        log.info("插入结果是："+result);
        if (result>0){
            return new CommonResult<>(200,"插入成功，访问的port:"+port,result);
        }
        return new CommonResult<>(500,"插入失败",null);
    }

    /*
        服务发现配置：
            1，导入DiscoveryClient对象，该对象在cloud包下不是netflix包
            2，在主程序上开启注解：@EnableDiscoveryClient
     */
    @GetMapping("discovery")
    public void getDiscovery(){
        /*查看eureka上注册的所有服务名称*/
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        /*根据服务名称，查看该服务名称下的所有服务实例*/
        List<ServiceInstance> instances = discoveryClient.getInstances("MYPROVIDERPAYMENT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"---"+instance.getHost()+"---"+instance.getPort()+"---"+instance.getUri());
        }
    }

    /*
        测试自定义负载均衡算法
     */
    @GetMapping("/lb")
    public String lbTest(){
        return port;
    }



    /*
        zipkin+sleuth,服务链路追踪测试
     */
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }



}
