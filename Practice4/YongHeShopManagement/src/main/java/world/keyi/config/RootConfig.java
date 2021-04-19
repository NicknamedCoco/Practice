package world.keyi.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.sql.DataSource;

/**
 * @author 万一
 * @date 2021年04月19日8:54
 */
@EnableAspectJAutoProxy         /*开启自动代理*/
@EnableTransactionManagement    /*开启事务管理*/
@ComponentScan(value = "world.keyi",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = ControllerAdvice.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
})
@Import({DruidDataSourceConfiguration.class,MybatisConfiguration.class})
public class RootConfig {

}
