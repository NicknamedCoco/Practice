package world.keyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.bean.Order;
import world.keyi.mapper.OrderMapper;
import world.keyi.service.OrderService;

import java.util.List;

/**
 * @author 万一
 * @date 2021年04月19日15:58
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public Integer deleteOrder(Integer id) {
        Integer num = orderMapper.deleteOrder(id);
        return num;
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public Integer updateOrder(Order order) {
        Integer num = orderMapper.updateOrder(order);
        return num;
    }


}
