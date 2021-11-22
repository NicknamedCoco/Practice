package world.keyi;


import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
public class AccountServiceMain
{
    public static void main( String[] args )
    {
        SpringApplication.run(AccountServiceMain.class,args);
    }
}
