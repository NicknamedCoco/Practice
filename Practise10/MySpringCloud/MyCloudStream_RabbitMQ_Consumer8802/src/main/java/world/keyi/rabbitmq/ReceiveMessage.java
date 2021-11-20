package world.keyi.rabbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 万一
 * @date 2021年10月27日22:23
 */
@Component
@EnableBinding(Sink.class)  //Spring cloud stream注解
public class ReceiveMessage {
    @Value("${server.port}")
    private String port;

    /*
        从别人那里拿消息，所以自己是消费者，input
        把消息给别人，所有自己是生产者，ouput
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg){
        System.out.println("消费者1号 -----》接收到的消息："+msg.getPayload()+"\t,"+port);
    }
}
