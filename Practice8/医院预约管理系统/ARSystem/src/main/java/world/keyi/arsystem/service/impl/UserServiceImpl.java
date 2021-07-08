package world.keyi.arsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.mapper.UserMapper;
import world.keyi.arsystem.service.UserService;
import world.keyi.arsystem.utils.MD5Util;
import world.keyi.arsystem.utils.QueryRequest;
import world.keyi.arsystem.utils.ResultGenerator;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 万一
 * @date 2021年06月22日11:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> queryAdminUser(QueryRequest queryRequest, User user) {
        IPage<User> userPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(),true);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role_id",0)
                .like(!ObjectUtils.isEmpty(user.getUsername()),"username",user.getUsername())
                .like(!ObjectUtils.isEmpty(user.getMobile()),"mobile",user.getMobile())
                .between(!ObjectUtils.isEmpty(queryRequest.getBeginTime())&&!ObjectUtils.isEmpty(queryRequest.getEndTime()),
                        "create_time",queryRequest.getBeginTime(),queryRequest.getEndTime())
                .orderByDesc("create_time");
        return userMapper.selectPage(userPage,userQueryWrapper);
    }

    @Override
    public IPage<User> queryDoctorUser(QueryRequest queryRequest, User user) {
        IPage<User> userPage = new Page<>(queryRequest.getPageNum(),queryRequest.getPageSize(),true);
        IPage<User> userIPage = userMapper.queryDoctorUser(userPage,queryRequest, user);
        return userIPage;
    }

    @Override
    public IPage<User> queryPatientsUser(QueryRequest queryRequest, User user) {
        IPage<User> userPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(),true);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role_id",2)
                .like(!ObjectUtils.isEmpty(user.getUsername()),"username",user.getUsername())
                .like(!ObjectUtils.isEmpty(user.getMobile()),"mobile",user.getMobile())
                .between(!ObjectUtils.isEmpty(queryRequest.getBeginTime())&&!ObjectUtils.isEmpty(queryRequest.getEndTime()),
                        "create_time",queryRequest.getBeginTime(),queryRequest.getEndTime())
                .orderByDesc("create_time");
        return userMapper.selectPage(userPage,userQueryWrapper);
    }

    @Override
    public boolean insertUser(Integer roleId, User entity) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",entity.getUsername());
        User user = this.getOne(userQueryWrapper);
        if (ObjectUtils.isNull(user)){
            entity.setCreateTime(new Date());
            entity.setPassword(MD5Util.MD5Encode("123765","utf-8"));
            entity.setRoleId(roleId);
            this.save(entity);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteUsers(Integer[] userIds) {
        boolean flag = false;
        for (Integer userId : userIds) {
            User user = this.getById(userId);
            if (!user.getUsername().equals("admin")){
                this.removeById(userId);
            }else {
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public User queryDoctorInfoByUsername(String nickName) {
        String sql ="select u.*,d.dep_name as depName from t_user u left join t_department d on u.dep_id=d.id" +
                " where u.nick_name='"+nickName+"'";
        return userMapper.queryDoctorInfoByUsername(sql);
    }
}
