package club.banyuan.myblog.form;

import club.banyuan.myblog.module.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;

public class LoginForm {
    @Size(min = 1,max = 5,message = "用户名输入错误")
    private String username;
    @Size(min = 3,message = "密码输入错误")
    private String password;
    @Size(min = 11,message = "邮箱输入错误")
    private String email;

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

    public User toUser(){
        User user=new User(this.username,this.password);
        return user;
    }
}
