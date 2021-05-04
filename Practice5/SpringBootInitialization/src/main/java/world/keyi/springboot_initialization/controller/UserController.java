package world.keyi.springboot_initialization.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.keyi.springboot_initialization.bean.PO.UserPO;
import world.keyi.springboot_initialization.service.UserService;

import java.util.List;

/**
 * @author 万一
 * @date 2021年05月04日10:00
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String queryAllUser(Model model,@RequestParam(value = "pageNum",defaultValue = "1") Long pageNum){
        //pageNum是前端传递过来的值，2表示每页查2条数据
        Page<UserPO> page = new Page<>(pageNum,2);
        Page<UserPO> userPage = userService.page(page,null);
        model.addAttribute("page",userPage);
        return "users";
    }
}
