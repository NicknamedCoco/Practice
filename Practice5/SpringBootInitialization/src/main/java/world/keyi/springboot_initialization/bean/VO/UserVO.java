package world.keyi.springboot_initialization.bean.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author 万一
 * @date 2021年05月03日16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

   private String id;

   @NotEmpty
   private String username;

   @Length(max = 10)
   @NotEmpty
   private String password;

   @Email
   private String email;
}
