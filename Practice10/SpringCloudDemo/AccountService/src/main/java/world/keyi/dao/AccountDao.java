package world.keyi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import world.keyi.bean.Account;

import java.util.List;

@Mapper
public interface AccountDao {
    public List<Account> getAccountList();
    public Integer reduceAccount(@Param("userId") String userId,@Param("money") String money);
}
