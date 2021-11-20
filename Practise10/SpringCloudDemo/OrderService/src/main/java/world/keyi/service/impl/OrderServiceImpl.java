package world.keyi.service.impl;

import com.alibaba.nacos.common.utils.UuidUtils;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import world.keyi.bean.Order;
import world.keyi.dao.OrderDao;
import world.keyi.feign.AccountServiceFeign;
import world.keyi.feign.StorageServiceFeign;
import world.keyi.service.OrderService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author 万一
 * @date 2021年11月15日18:29
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountServiceFeign accountServiceFeign;

    @Resource
    private StorageServiceFeign storageServiceFeign;

    @Override
    public Integer addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public Integer updateOrderStatus(String userId, String status) {
        return orderDao.updateOrderStatus(userId,status);
    }

    /*
    * 案例主方法：增加订单--->扣减账户余额--->扣减库存--->更改订单状态
    * */
    @Override
    @GlobalTransactional(name = "order_create",rollbackFor = Exception.class)
    public Integer create(Order order) {
        orderDao.addOrder(order);
        /*
            feign接口不能有异常处理，需要错误需要暴露在这里，不然seata任务没有报错，不回滚数据库
         */
        accountServiceFeign.reduceAccount(order.getUserId(),order.getMoney());
        storageServiceFeign.reduceStorage(order.getProductId(),order.getCount());
        Integer result = orderDao.updateOrderStatus(order.getUserId(),"1");
        return result;	//若修改状态成功，则返回1，否则为0
    }
}
