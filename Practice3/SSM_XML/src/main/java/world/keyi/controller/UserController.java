package world.keyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import world.keyi.domain.User;
import world.keyi.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;

    public UserController() {
        System.out.println("UserController已创建");
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView findAllUser(){
        ModelAndView mav = new ModelAndView("system");
        List<User> users = userService.findAllUser();
        System.out.println("这里是controller层，users为：");
        System.out.println(users);
        mav.addObject("users",users);
        return mav;
    }

    @RequestMapping("/findUserByUsernameAndEmail")
    public ModelAndView findUserByUsernameAndEmail(@RequestParam("username") String username,
                                                   @RequestParam("email") String email){
        ModelAndView mav = new ModelAndView("system");
        User user = userService.findUserByUsernameAndEmail(username, email);
        System.out.println(user);
        if (user!=null){
            mav.addObject("user",user);
        }else{
            mav.addObject("error","查询失败");
        }
        return mav;
    }

}
