package world.keyi.arsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import world.keyi.arsystem.utils.AgeFromBirthdayUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 万一
 * @date 2021年06月22日10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;             //用户id
    private String username;            //用户名
    private String nickName;            //用户昵称/真实姓名
    private String password;            //密码
    private String email;               //邮箱
    private String mobile;              //联系电话
    private String lastLoginIp;         //上次登录Ip
    private Integer ssex;               //性别 0男 1女 2保密
    private String description;         //描述
    private String avatar;              //用户头像
    private String school;              //医生毕业院校
    private Integer depId;              //医生科室Id
    private Integer status;             //状态 0锁定 1有效,默认为1
    private Integer roleId;             //角色，0为超级管理员，1为医生，2为患者


    private Date lastLoginTime;         //最近访问时间


    private Date createTime;            //创建时间


    private Date modifyTime;           //修改时间

    private Date birthday;              //生日

    @TableField(exist = false)
    private String depName;

    @TableField(exist = false)
    private Integer age;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        this.age=AgeFromBirthdayUtil.getCurrentAge(birthday);
    }
}
