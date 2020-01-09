package club.banyuan.myblog.form;

import club.banyuan.myblog.module.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;

public class RegisterForm {
    @Size(min = 1,max = 5,message = "用户名输入错误")
    private String name;
    @Size(min = 3,message = "密码输入错误")
    private String password;
    @Size(min = 11,message = "邮箱输入错误")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toUser(){
        User user=new User(this.name,this.password,this.email);
        return user;
    }
}
