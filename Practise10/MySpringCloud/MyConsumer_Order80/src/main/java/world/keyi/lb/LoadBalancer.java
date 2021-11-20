package world.keyi.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance selectInstance(List<ServiceInstance> instances);
}
