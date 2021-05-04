package world.keyi.springboot_initialization.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 万一
 * @date 2021年04月30日9:22
 */
@Configuration
public class MyDataSource {

    /*
        配置druid数据源
	    这会导致底层默认使用的HikariDataSource无效，因为@ConditionalOnMissingBean(DataSource.class)

        @ConfigurationProperties("spring.datasource")的意思是
        使得DruidDataSource中各个属性与配置文件中的spring.datasource进行绑定
    */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
