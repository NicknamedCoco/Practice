package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import world.ribbon_rule.RobbonRuleConfig;

/**
 * @author 万一
 * @date 2021年10月17日23:47
 */
@SpringBootApplication
@EnableEurekaClient
//更改ribbon默认的负载均衡算法，轮询改成随机
//@RibbonClient(name = "MYPROVIDERPAYMENT",configuration = RobbonRuleConfig.class)
public class MyConsumerOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerOrder80.class,args);
    }
}
