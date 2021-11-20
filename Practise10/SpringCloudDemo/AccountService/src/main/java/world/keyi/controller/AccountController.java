package world.keyi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.bean.Account;
import world.keyi.result.CommonResult;
import world.keyi.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 万一
 * @date 2021年11月15日18:26
 */
@RestController
@RefreshScope
@RequestMapping("/account")
public class AccountController {

    @Value("${info}")
    private String info;

    @Resource
    private AccountService accountService;

    @RequestMapping("/nacos")
    public String nacosTest(){
        return info;
    }

    @RequestMapping("/list")
    public CommonResult<List<Account>> getAccountList(){
        return new CommonResult<>(200, "success", accountService.getAccountList());
    }

    @PutMapping("/")
    public CommonResult<Integer> reduceAccount(@RequestParam("userId") String userId,@RequestParam("money") String money){
        if (accountService.reduceAccount(userId,money)!=1) {
            return new CommonResult<>(500,"error");
        }
        return new CommonResult<>(200,"success");
    }

}
