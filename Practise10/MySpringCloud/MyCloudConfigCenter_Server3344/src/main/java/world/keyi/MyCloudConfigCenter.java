package world.keyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 万一
 * @date 2021年10月27日12:18
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer     //springCloud config的注解
public class MyCloudConfigCenter {

    /**
     * 这个模块应该是尚硅谷网课中的springCloud config的分布式配置中心，端口号是3344
     *  但是springCloud config有一个问题，config获取的是远程仓库的数据，gitee或者github上的数据，
     *  当github上的配置更改时，使用该模块的实例，例如网课中的3355,3366这些模块中的配置并没有自动更新，需要重新启动3355,3366
     *  不重启下面这些实例的话，你就需要手动curl刷新这些模块暴露出来的端点，并且需要每个模块刷新一次端点，非常麻烦
     *
     *  所以springCloud bus孕育而生，bus是配合config一起使用的，它能帮助使用了配置中心下面的服务实例的配置得到更新
     *  具体是bus底层使得每个服务实例订阅了rabbitMQ的一个topic，就是让这些实例订阅名字为springCloud bus的topic
     *  然后我们只需要去刷新springCloud config暴露出来的端点(curl -X POST "http://localhost:3344/actuator/bus-refresh)后
     *  下面所有的服务实例的配置都得到了刷新。
     *
     *  由于idea连接github多次失败，尝试了很多次都难以成功，并且配置rabbitMQ，springCloud bus，springCloud config非常麻烦
     *  我就没有去实验，配置繁琐，用了各种框架去实现分布式配置中心，并且勉强达到配置热更新(还是需要刷新配置中心的端点)
     *  为什么不用nacos呢？nacos既可以用来作为分布式注册中心，又能做分布式配置中心，而且轻易能实现配置热更新，不需要刷新端点。
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MyCloudConfigCenter .class,args);
    }
}
