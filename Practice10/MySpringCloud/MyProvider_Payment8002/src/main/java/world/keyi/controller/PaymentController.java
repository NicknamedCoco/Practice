package world.keyi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import world.keyi.entities.CommonResult;
import world.keyi.entities.Payment;
import world.keyi.service.PaymentService;

import javax.annotation.Resource;
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
        测试自定义负载均衡算法
     */
    @GetMapping("/lb")
    public String lbTest(){
        return port;
    }

}
