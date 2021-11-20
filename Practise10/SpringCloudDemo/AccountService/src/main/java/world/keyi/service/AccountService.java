package world.keyi.service;

import world.keyi.bean.Account;

import java.util.List;


public interface AccountService {
    List<Account> getAccountList();

    Integer reduceAccount(String userId, String money);
}
