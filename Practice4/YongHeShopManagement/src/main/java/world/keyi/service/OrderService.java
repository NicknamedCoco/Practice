package world.keyi.service;

import org.springframework.stereotype.Service;
import world.keyi.bean.Order;

import java.util.List;

@Service
public interface OrderService {
    public List<Order> getAllOrder();

    public void addOrder(Order order);

    public Integer deleteOrder(Integer id);

    public Order getOrderById(Integer id);

    public Integer updateOrder(Order order);
}
