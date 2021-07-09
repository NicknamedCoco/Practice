package world.keyi.arsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import world.keyi.arsystem.annotation.LoginToken;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.service.UserService;
import world.keyi.arsystem.utils.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 万一
 * @date 2021年06月28日11:26
 */
@RestController
@RequestMapping("/adminApi/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QiniuUtil qiniuUtil;

    /*
        查询用户列表，给参数
     */
    @GetMapping("/list")
    @LoginToken
    public Result listUser(QueryRequest queryRequest, User user){
        return ResultGenerator.genSuccessResult(userService.queryAdminUser(queryRequest,user));
    }

    /*
        查询用户
     */
    @GetMapping("/{userId}")
    public Result getUser(@PathVariable Integer userId){
        User user = userService.getById(userId);
        return ResultGenerator.genSuccessResult(user);
    }

    /*
        添加用户
        @PostMapping和@PostMapping("/")有区别
     */
    @PostMapping
    public Result insert(@RequestBody User entity){
        boolean isSuccess = userService.insertUser(0, entity);
        if (isSuccess){
            return ResultGenerator.genSuccessResult("用户"+entity.getUsername()+"新增成功，默认密码为：123765");
        }else {
            return ResultGenerator.genErrorResult(201,"用户新增失败，"+entity.getUsername()+"已存在");
        }
    }

    /*
        修改用户
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
        用户密码重置,给用户id，密码，用户名
     */
    @PutMapping("/resetPwd")
    public Result resetUserPwd(@RequestBody User user){
        user.setPassword(MD5Util.MD5Encode(user.getPassword(),"utf-8"));
        userService.updateById(user);
        return ResultGenerator.genSuccessResult();
    }

    /*
        用户状态修改,给用户id，和状态
        updateById方法只修改数据库的status属性，并不会修改其他属性，mybatis我还是不太熟悉
     */
    @PutMapping("/changeStatus")
    public Result changeUserStatus(@RequestBody User user){
        userService.updateById(user);
        return ResultGenerator.genSuccessResult();
    }

    /*
        查询用户个人信息
     */
    @GetMapping("/profile")
    @LoginToken
    public Result getUserProfile(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Integer userId = TokenUtil.getAdminUserId(token);
        return ResultGenerator.genSuccessResult(userService.getById(userId));
    }

    /*
        修改用户个人信息
     */
    @PutMapping("/profile")
    @LoginToken
    public Result updateUserProfile(@RequestBody User user){
        boolean flag = userService.updateById(user);
        if (flag){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("更新失败");
        }
    }

    /*
        用户密码重置
     */
    @PutMapping("/profile/updatePwd")
    public Result updateUserPwd(QueryRequest queryRequest,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Integer userId = TokenUtil.getAdminUserId(token);
        User user = userService.getById(userId);
        if (user.getPassword().equalsIgnoreCase(MD5Util.MD5Encode(queryRequest.getOldPassword(),"utf-8"))){
            User u = new User();
            u.setUserId(userId);
            u.setPassword(MD5Util.MD5Encode(queryRequest.getNewPassword(),"utf-8"));
            userService.updateById(u);
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genErrorResult(201,"原始密码不正确");
        }
    }


    /*
        用户头像上传,给参数
     */
    @PostMapping("/profile/avatar")
    public Result uploadAvatar(@RequestParam("avatarfile") MultipartFile file, HttpServletRequest request){

        //上传到本地
        /*Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        Map<String, Object> map = UploadFileUtil.uploadImage(file);
        if ((int) (map.get("status"))==200&&(boolean)map.get("isImage")){
            User user = new User();
            user.setAvatar((String) map.get("requestUrl"));
            user.setUserId(userId);
            userService.updateById(user);
            return ResultGenerator.genSuccessResult(map.get("requestUrl"));
        }else {
            return ResultGenerator.genFailResult("图片上传失败");
        }*/

        //上传到七牛云
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        User user = new User();
        user.setUserId(userId);
        String requestUrl = qiniuUtil.uploadFile(file);
        user.setAvatar("http://"+requestUrl);
        userService.updateById(user);
        return ResultGenerator.genSuccessResult(requestUrl);
    }

    /*
        下载用户导入模板
     */
    @GetMapping("/importTemplate")
    public String importTemplate(){
        return "";
    }

    /*
        导出用户,给参数
     */
    @GetMapping("/export")
    public String exportUser(){
        return "";
    }

}
