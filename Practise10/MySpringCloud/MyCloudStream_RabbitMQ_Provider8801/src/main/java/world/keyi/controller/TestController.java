package world.keyi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.service.IMessageSend;
import world.keyi.service.MessageSendImpl;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年10月27日21:14
 */
@RestController
public class TestController {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @Resource
    private IMessageSend messageSend;

    @RequestMapping("/person")
    public String getPersonInfo(){
        return name+","+age;
    }

    @RequestMapping("/send")
    public void sendMsg(){
        messageSend.send();
    }
}
