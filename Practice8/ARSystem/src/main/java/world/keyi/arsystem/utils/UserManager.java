/**
 * 项目名：emp
 * 日  期：2020/5/22
 * 包  名：vip.penint.dandp.utils
 *
 * @author： niko_hxx
 */
package world.keyi.arsystem.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.service.UserService;
@Service
public class UserManager {

    @Autowired
    private UserService userService;


    /**
     * 根据UserId 判断是否是管理员角色,与上面方法判断存在差异
     */
    public boolean isAdminRole(Integer userId) {
        User user = userService.getById(userId);
        if (user.getRoleId() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据UserId 判断是否是医生
     */
    public boolean isDoctorRole(Integer userId) {
        User user = userService.getById(userId);
        if (user.getRoleId() == 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 根据UserId 判断是否是学生
     */
    public boolean isPatientsRole(Integer userId) {
        User user = userService.getById(userId);
        if (user.getRoleId() == 2) {
            return true;
        } else {
            return false;
        }
    }
}