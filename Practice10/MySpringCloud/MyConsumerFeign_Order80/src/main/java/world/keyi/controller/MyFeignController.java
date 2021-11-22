package world.keyi.controller;

import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/order/feign/")
public class MyFeignController {
    @Resource
    MyFeignWithPayment myFeignWithPayment;

    @GetMapping("/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        log.info("正在获取支付接口数据");
        return  myFeignWithPayment.queryById(id);
    }
}
