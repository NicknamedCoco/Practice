package world.keyi.mapper;

import world.keyi.bean.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> getAllOrder();

    public void addOrder(Order order);

    public Integer deleteOrder(Integer id);

    public Order getOrderById(Integer id);

    public Integer updateOrder(Order order);
}
