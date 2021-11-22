package world.keyi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import world.keyi.entities.Payment;

@Mapper
public interface PaymentDao {

    public int insert(Payment payment);
    public Payment queryById(@Param("id")Long id);

}
