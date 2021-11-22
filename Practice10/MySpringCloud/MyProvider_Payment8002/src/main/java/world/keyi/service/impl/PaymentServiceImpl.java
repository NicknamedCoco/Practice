package world.keyi.service.impl;


import org.springframework.stereotype.Service;
import world.keyi.dao.PaymentDao;
import world.keyi.entities.Payment;
import world.keyi.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年10月17日21:12
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }
}
