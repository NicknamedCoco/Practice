package world.keyi.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 万一
 * @date 2021年10月19日18:31
 */
@RestController
@Slf4j
@RequestMapping("/payment/nacos")
public class MyProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("")
    public String getInfo(){
        return "您正在访问nacos注册中心的某个服务，服务端口号为："+port+"\t"+ UUID.randomUUID().toString();
    }

}
