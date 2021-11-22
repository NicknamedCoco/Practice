package world.keyi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import world.keyi.bean.Order;

@Mapper
public interface OrderDao {
    Integer addOrder(Order order);
    Integer updateOrderStatus(@Param("userId") String userId,@Param("status") String status);
}
