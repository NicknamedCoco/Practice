package world.keyi.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Component
public class User {

    @NotEmpty
    @Length(message = "用户名不能为空")
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email(message = "邮箱不符合格式")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public User(@NotEmpty @Length(message = "用户名不能为空") String username,
                @NotEmpty String password,
                @NotEmpty @Email(message = "邮箱不符合格式") String email,
                Date birthday) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
