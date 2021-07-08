package world.keyi.arsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.utils.QueryRequest;

public interface UserService extends IService<User> {
    IPage<User> queryAdminUser(QueryRequest queryRequest, User user);
    IPage<User> queryDoctorUser(QueryRequest queryRequest, User user);
    IPage<User> queryPatientsUser(QueryRequest queryRequest, User user);
    boolean insertUser(Integer roleId, User entity);
    boolean deleteUsers(Integer[] userIds);
    User queryDoctorInfoByUsername(String nickName);
}
