package world.keyi.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import world.keyi.bean.Order;
import world.keyi.controller.sentinel.OrderDegradeAndException;
import world.keyi.result.CommonResult;
import world.keyi.service.OrderService;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年11月15日18:27
 */
@RestController
@RequestMapping("order")
@RefreshScope
public class OrderController {

    @Resource
    private OrderService orderService;

    @Value("${info}")
    private String info;

    @RequestMapping("/nacos")
    @SentinelResource(
            value = "nacos",
            blockHandlerClass = OrderDegradeAndException.class,blockHandler = "info_degrade",
            fallbackClass = OrderDegradeAndException.class,fallback = "info_exception")
    public String nacosTest(){
        return info;
    }

    @PostMapping("/")
    @SentinelResource(
            value = "create",
            blockHandlerClass = OrderDegradeAndException.class,blockHandler = "create_degrade",
            fallbackClass = OrderDegradeAndException.class,fallback = "create_exception")
    public CommonResult<Integer> create(@RequestBody Order order){
        order.setStatus("0");
        return new CommonResult<>(200,"success",orderService.create(order));
    }

    @PutMapping("/")
    public CommonResult<Integer> updateOrderStatus(@RequestParam("userId") String userId, @RequestParam("status") String status){
        return new CommonResult<>(200,"success",orderService.updateOrderStatus(userId,status));
    }
}
