package world.keyi.springboot_initialization.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ramostear.captcha.HappyCaptcha;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import world.keyi.springboot_initialization.bean.PO.UserPO;
import world.keyi.springboot_initialization.bean.VO.UserVO;
import world.keyi.springboot_initialization.config.utils.Result;
import world.keyi.springboot_initialization.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 万一
 * @date 2021年04月30日10:05
 */
@Controller
public class LoginController {

    @Autowired
    UserService userServiceImpl;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/login2")
    public String login(UserVO userVO, String code, HttpServletRequest request,
                        RedirectAttributes redirectAttributes, Model model,
                        HttpSession session){
        //验证前端校验码
        boolean flag = HappyCaptcha.verification(request, code, true);
        String returnValue;
        if (flag){
            UserPO userPO = userServiceImpl.getOne(new QueryWrapper<UserPO>().eq("username",userVO.getUsername()));
            if (userPO!=null){
                if (passwordEncoder.matches(userVO.getPassword(),userPO.getPassword())){
                    model.addAttribute("loginResult","登录成功");
                    session.setAttribute("user",userPO);
                    returnValue="home";
                }else {
                    redirectAttributes.addFlashAttribute("loginResult","密码错误，请重新登录");
                    returnValue="redirect:/toIndex";
                }
            }else {
                redirectAttributes.addFlashAttribute("loginResult","用户名不存在，请重新登录");
                returnValue="redirect:/toIndex";
            }
        }else {
            redirectAttributes.addFlashAttribute("loginResult","验证码错误，请重新登录");
            returnValue="redirect:/toIndex";
        }
        return returnValue;
    }


    @RequestMapping("/toIndex")
    public String RedirectToIndex(){
        return "index";
    }

}
