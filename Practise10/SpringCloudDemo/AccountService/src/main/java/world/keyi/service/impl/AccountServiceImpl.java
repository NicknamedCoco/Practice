package world.keyi.service.impl;

import org.springframework.stereotype.Service;
import world.keyi.bean.Account;
import world.keyi.dao.AccountDao;
import world.keyi.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 万一
 * @date 2021年11月15日18:24
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public List<Account> getAccountList() {
        return accountDao.getAccountList();
    }

    @Override
    public Integer reduceAccount(String userId, String money) {
        return accountDao.reduceAccount(userId,money);
    }
}
