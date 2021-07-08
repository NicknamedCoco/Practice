package world.keyi.arsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.service.UserService;
import world.keyi.arsystem.service.impl.UserServiceImpl;
import world.keyi.arsystem.utils.MD5Util;
import world.keyi.arsystem.utils.Result;
import world.keyi.arsystem.utils.ResultGenerator;
import world.keyi.arsystem.utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 万一
 * @date 2021年06月28日11:08
 */
@RestController
@RequestMapping("/adminApi/common")
public class LoginController {

    @Autowired
    private UserService userService;

    /*
        登录
     */
    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password)) {
            return ResultGenerator.genFailResult("用户名或密码不能为空");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", MD5Util.MD5Encode(password, "utf-8"));
        queryWrapper.allEq(params);
        User user = userService.getOne(queryWrapper);

        if (ObjectUtils.isNotNull(user)) {
            HashMap<String, Object> obj = new HashMap<>();
            obj.put("userInfo",user);
            obj.put("token", TokenUtil.getAdminToken(user));
            return ResultGenerator.genSuccessResult(obj);
        } else {
            return ResultGenerator.genFailResult("用户不存在");
        }
    }

    //outLogin，登出
    @GetMapping("/outLogin")
    public Result outLogin() {
        return ResultGenerator.genSuccessResult();
    }

    //getUserInfo，获取信息
    @GetMapping("/getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        User user = userService.getById(TokenUtil.getAdminUserId(request.getHeader("Authorization")));
        if (user == null) {
            return ResultGenerator.genFailResult("账号不存在,请检查账号是否正确或联系管理员");
        } else {
            HashMap<String, Object> obj = new HashMap<>();
            obj.put("userInfo", user);
            obj.put("token", TokenUtil.getAdminToken(user));
            return ResultGenerator.genSuccessResult(obj);
        }
    }

    //registerPatients，注册病人，给参数
    @PostMapping("/registerPatients")
    public String registerPatients() {
        return "";
    }

    //registerDoctor，注册医生,给参数
    @PostMapping("/registerDoctor")
    public String registerDoctor() {
        return "";
    }

    //forgotPassword，忘记密码，给参数
    @PutMapping("/forgotPassword")
    public String forgotPassword() {
        return "";
    }
}
