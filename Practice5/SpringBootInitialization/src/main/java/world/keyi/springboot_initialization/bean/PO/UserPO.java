package world.keyi.springboot_initialization.bean.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author 万一
 * @date 2021年04月30日10:04
 * <p>
 * 这里有lombok，hibernate-validator,mybatis-plus的注解
 */

@NoArgsConstructor
@Data
@TableName("tb_user")
public class UserPO {

    public UserPO(String username, String password, String email, Date createTime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createTime = createTime;
    }

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Date createTime;
}
