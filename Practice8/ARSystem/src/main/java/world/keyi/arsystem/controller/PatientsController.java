package world.keyi.arsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.annotation.LoginToken;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.service.UserService;
import world.keyi.arsystem.utils.MD5Util;
import world.keyi.arsystem.utils.QueryRequest;
import world.keyi.arsystem.utils.Result;
import world.keyi.arsystem.utils.ResultGenerator;

/**
 * @author 万一
 * @date 2021年06月22日23:25
 */
@RestController
@RequestMapping("/adminApi/patiens")
public class PatientsController {

    @Autowired
    private UserService userService;

    /*
        查询用户列表,给参数
     */
    @GetMapping("/list")
    @LoginToken
    public Result listUser(QueryRequest queryRequest, User user){
        return ResultGenerator.genSuccessResult(userService.queryPatientsUser(queryRequest,user));
    }

    /*
        查询用户详细,给id
     */
    @GetMapping("/{userId}")
    public Result getUser(@PathVariable Integer userId){
        User user = userService.getById(userId);
        return ResultGenerator.genSuccessResult(user);
    }

    /*
        新增用户,给参数
     */
    @PostMapping
    public Result insert(@RequestBody User entity){
        boolean isSuccess = userService.insertUser(2, entity);
        if (isSuccess){
            return ResultGenerator.genSuccessResult("用户"+entity.getUsername()+"新增成功，默认密码为：123765");
        }else {
            return ResultGenerator.genErrorResult(201,"用户新增失败，"+entity.getUsername()+"已存在");
        }
    }

    /*
        修改用户,给参数
     */
    @PutMapping
    public Result updateUser(@RequestBody User user){
        userService.updateById(user);
        return ResultGenerator.genSuccessResult();
    }

    /*
        删除用户，给id
     */
    @DeleteMapping("/{userIds}")
    public Result delUser(@PathVariable Integer[] userIds){
        boolean flag = userService.deleteUsers(userIds);
        if (flag){
            return ResultGenerator.genFailResult("admin用户不能删除");
        }else {
            return ResultGenerator.genSuccessResult();
        }
    }

    /*
        用户密码重置,给id，密码，用户名
     */
    @PutMapping("/resetPwd")
    public Result resetUserPwd(@RequestBody User user){
        user.setPassword(MD5Util.MD5Encode(user.getPassword(),"utf-8"));
        userService.updateById(user);
        return ResultGenerator.genSuccessResult();
    }
    /*
        用户状态修改,给用户id，状态status
     */
    @PutMapping("/changeStatus")
    public Result changeUserStatus(@RequestBody User user){
        userService.updateById(user);
        return ResultGenerator.genSuccessResult();
    }
}
