package world.keyi.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 万一
 * @date 2021年10月20日17:43
 */
@Component
public class MyLoadBalancer implements LoadBalancer {
    /*
        自定义负载均衡算法，实现轮询算法，轮询算法根据:rest请求次数%可用服务集合总数等于index下标
        根据该index下标，从而获取可用服务集合中某个微服务。

        该算法要做两件事，一是rest请求次数需要在多线程的环境下每次都自增，二是通过取余拿到下标值，返回指定的服务实例
        主要问题是rest请求需要在多线程环境下保持自增，我们通过CAS+自旋锁的方式使得rest请求数自增+1
     */

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current,next;
        do{     //通过do-while不断自旋
            current = atomicInteger.get();      //根据内存地址拿到主内存中共同的值到本地内存中
            next = current >=2147483647 ? 0: current+1;
        }while (!atomicInteger.compareAndSet(current,next));    //如果current值不变，则将current对应的地址中的值改成next，有乐观锁感觉了
        return next;
    }

    @Override
    public ServiceInstance selectInstance(List<ServiceInstance> instances) {
        return instances.get(getAndIncrement()%instances.size());
    }
}
