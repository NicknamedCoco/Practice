package world.keyi.arsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.annotation.LoginToken;
import world.keyi.arsystem.entity.Department;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.service.DepartmentService;
import world.keyi.arsystem.service.UserService;
import world.keyi.arsystem.service.impl.UserServiceImpl;
import world.keyi.arsystem.utils.MD5Util;
import world.keyi.arsystem.utils.Result;
import world.keyi.arsystem.utils.ResultGenerator;
import world.keyi.arsystem.utils.TokenUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author 万一
 * @date 2021年06月22日23:24
 */
@RestController
@RequestMapping(value = "adminApi/common")
public class CommonController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    /*
        表单校验 新增用户时验证库里是否有重复用户名
     */
    @GetMapping("/checkUsername/{username}")
    public Object checkUsername(@PathVariable String username){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        if (userService.getOne(userQueryWrapper)!=null){
            return ResultGenerator.genSuccessResult(true);
        }
        return ResultGenerator.genSuccessResult(false);
    }

    /*
        表单校验 修改个人密码时验证旧密码是否正确
     */
    @GetMapping("/checkPassword/{oldPsw}")
    @LoginToken
    public Result checkPassword(@PathVariable("oldPsw") String oldPassword,HttpServletRequest request){
        if (ObjectUtils.isEmpty(oldPassword)){
            return ResultGenerator.genSuccessResult(false);
        }
        String token = request.getHeader("Authorization");
        User user = userService.getById(TokenUtil.getAdminUserId(token));
        if (user.getPassword().equalsIgnoreCase(MD5Util.MD5Encode(oldPassword,"utf-8"))){
            return ResultGenerator.genSuccessResult(true);
        }else {
            return ResultGenerator.genSuccessResult(false);
        }
    }

    /*
        获取科室下拉框
     */
    @GetMapping("/getDepartment")
    public Result getDepartment(){
        return ResultGenerator.genSuccessResult(departmentService.list());
    }

    /*
        通过科室id查询医生
     */
    @GetMapping("/getDoctor/{id}")
    public Result getDoctorById(@PathVariable Integer id){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("dep_id",id);
        return ResultGenerator.genSuccessResult(userService.list(userQueryWrapper));
    }

    /*
        通过用户名查询医生详情
     */
    @GetMapping("/getDoctorInfoByUsername/{nickName}")
    public Result getDoctorInfoByUsername(@PathVariable String nickName){
        return ResultGenerator.genSuccessResult(userService.queryDoctorInfoByUsername(nickName));
    }

}
