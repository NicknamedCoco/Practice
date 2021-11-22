package world.keyi.service;

import world.keyi.bean.Order;

public interface OrderService {
    Integer addOrder(Order order);

    Integer updateOrderStatus(String userId, String status);

    Integer create(Order order);
}
