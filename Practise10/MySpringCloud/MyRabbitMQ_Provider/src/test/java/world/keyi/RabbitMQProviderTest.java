package world.keyi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 万一
 * @date 2021年10月31日21:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQProviderTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void simpleQueueProvider(){
        String queueName = "simple.queue";
        String msg = "这里是简单消息队列测试消息";
        rabbitTemplate.convertAndSend(queueName,msg);
    }

    @Test
    public void workQueueProvider(){
        String queueName = "work.queue";
        String msg = "工作队列第";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName,msg+i+"条消息");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 交换机作用：接收消息并路由给队列，路由的规则是不同的
    *   fanoutExchange会将消息发给每一个绑定的队列
    *   directExchange会将接收到的消息根据规则(routingKey)路由到指定的Queue，因此称为路由模式(routes)
    *   topicExchange，和directExchange类似，不同的是，topicExchange的routingKey可以设置成通配符的形式，简化操作
    *       例如如果队列routingKey为：china.#   则匹配所有key是china.xxx的消息，类似正则匹配，#代表0或多个单词，*代表一个单词
    *
    * 交换机只能路由不能缓存消息，如果路由消息失败，则消息会丢失
    * */
    @Test
    public void fanoutExchangeProvider(){
        String exchangeName = "wanyi.fanout";
        String msg = "hello everyone!";
        rabbitTemplate.convertAndSend(exchangeName,"",msg);
    }

    @Test
    public void directExchangeProvider(){
        String exchangeName = "wanyi.direct";
        String msg = "hello red!!!";
        rabbitTemplate.convertAndSend(exchangeName,"red",msg);
    }

    @Test
    public void topicExchangeProvider(){
        String exchangeName = "wanyi.topic";
        String msg = "china fake new !!!";
        rabbitTemplate.convertAndSend(exchangeName,"china.news",msg);
    }
}
