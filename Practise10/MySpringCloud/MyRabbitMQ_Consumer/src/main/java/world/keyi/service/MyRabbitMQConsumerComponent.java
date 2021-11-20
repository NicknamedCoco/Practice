package world.keyi.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

/**
 * @author 万一
 * @date 2021年10月31日21:37
 */
@Component
public class MyRabbitMQConsumerComponent {
    /*simpleQueue测试*/
    @RabbitListener(queues = "simple.queue")
    public void simpleQueueTest(String msg){
        System.out.println("simple.queue----接收消息为："+msg);
    }

    /*workQueue测试，一个queue，两个消费者*/
    @RabbitListener(queues = "work.queue")
    public void workQueue1Test(String msg) throws InterruptedException {
        System.out.println("work.queue----消费者1接收消息为："+msg+ LocalTime.now());
        Thread.sleep(20);
    }
    @RabbitListener(queues = "work.queue")
    public void workQueue2Test(String msg) throws InterruptedException {
        System.err.println("work.queue----消费者2接收消息为："+msg+ LocalTime.now());
        Thread.sleep(200);
    }

    /*
     * 交换机根据路由规则不同，划分为三种交换机，fanoutExchange,directExchange,topicExchange
     * */

    /*fanoutExchange，两个queue，每个queue一个消费者*/
    @RabbitListener(queues = "fanout.queue1")
    public void fanoutQueue1Test(String msg){
        System.out.println("fanout.queue1----接收消息为："+msg);
    }
    @RabbitListener(queues = "fanout.queue2")
    public void fanoutQueue2Test(String msg){
        System.out.println("fanout.queue2----接收消息为："+msg);
    }


    /*directExchange，两个queue，每个queue一个消费者*/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "wanyi.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void directQueue1Test(String msg){
        System.out.println("direct.queue1----接收消息为："+msg);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "wanyi.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void directQueue2Test(String msg){
        System.err.println("direct.queue2----接收消息为："+msg);
    }


    /*directExchange，两个queue，每个queue一个消费者*/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "wanyi.topic",type = ExchangeTypes.TOPIC),
            key = {"china.#"}
    ))
    public void topicQueue1Test(String msg){
        System.out.println("topic.queue1----接收消息为："+msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "wanyi.topic",type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    ))
    public void topicQueue2Test(String msg){
        System.err.println("topic.queue2----接收消息为："+msg);
    }


}
