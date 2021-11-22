package world.ribbon_rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 万一
 * @date 2021年10月20日11:36
 */
@Configuration
public class RobbonRuleConfig {
    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
