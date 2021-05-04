package world.keyi.springboot_initialization.controller;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 万一
 * @date 2021年05月02日0:05
 */
@Controller
public class HappyCaptchaController {
    @GetMapping("/captcha")
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response){
        HappyCaptcha.require(request,response).build().finish();
    }
}
