package world.keyi.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.controller.global.CustomerBlockHandler;

/**
 * @author 万一
 * @date 2021年11月08日19:48
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(){
        System.out.println("test2");
        return "test2";
    }



    /*
        1，SentinelResource注解只能修饰public方法
        2，可以根据url限流或者SentinelResource的资源名限流
        3，如果SentinelResource注解配置了blockHandler选项，则找本类中找降级方法，
            如果同时配置了blockHandlerClass选项，则去指定的类中找降级方法。
        4，如果降级方法被放在其他类中，则该降级方法必须是静态的
            使用这种方式，在sentinel控制台配置的是根据资源名限流，而不是url路径
        4，如果配置了SentinelResource注解，但没有配置blockHandler选项，
            则使用sentinel默认的降级方法：返回"Blocked by Sentinel (flow limiting)"字符串
        5，需要注意的是，如果方法出现异常，blockHandler选项所指定的降级方法是处理不了的，需要开启fallback选项，指定fallback方法
            当blockHandler选项和fallback选项都配置时，会先走fallback指定的处理异常的方法，如果之后触发了限流熔断规则才会走blockHandler指定的方法。
        6，SentinelResource注解有一个exceptionToIgnore选项，该选项的值是一个对象，你可以指定某些异常发生时，不走fallback指定的方法。
            而是直接页面报错error page
        7，如果在openfeign和sentinel一起使用，则需要开启sentinel对feign的支持，在微服务配置文件中配置如下：
            feign:
              sentinel:
                enabled: true
           然后处理逻辑还是像之前的方式处理，只不过底层从使用默认的hystrix变成了sentinel.但是使用方式不变

     */
    @RequestMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "dealHotkey")
    public String hotkeyTest(@RequestParam("key1") String key1){
        System.out.println("正常处理的请求");
        return "正常的处理请求";
    }

    public String dealHotkey(String key, BlockException blockException){
        System.out.println("异常的处理");
        return "异常的处理";
    }


    /*
        将降级的方法提取到其他类中，在CustomerBlockHandler类中，降级方法必须是静态的
        使用这种方式，在sentinel控制台配置的是根据资源名限流，而不是url路径，
        如果是根据url限流，找的还是本类中的blockHandler方法，又因为这里没有配置，这里配置的是CustomerBlockHandler类的方法
        所以返回sentinel默认的降级方法：Blocked by Sentinel (flow limiting)
     */
    @RequestMapping("/handle")
    @SentinelResource(value = "handle",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public String globalExceptionTest(int id){
        System.out.println(id);
        return "正常的处理逻辑"+id;
    }



}
