package world.keyi.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 万一
 * @date 2021年10月27日21:49
 */

@EnableBinding(Source.class)
public class MessageSendImpl implements IMessageSend{

    @Resource(name = "output")
    private MessageChannel messageChannel;

    @Override
    public void send() {
        String msg = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(msg).build());
        System.out.println(msg);
    }
}
