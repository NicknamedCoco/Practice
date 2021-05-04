package world.keyi.springboot_initialization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import world.keyi.springboot_initialization.bean.PO.UserPO;
import world.keyi.springboot_initialization.mapper.UserMapper;
import world.keyi.springboot_initialization.service.UserService;

/**
 * @author 万一
 * @date 2021年04月30日10:21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

}
