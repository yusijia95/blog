package club.banyuan.myblog.controller;

import club.banyuan.myblog.annotation.LoggerAnnotation;
import club.banyuan.myblog.form.RegisterForm;
import club.banyuan.myblog.module.User;
import club.banyuan.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @LoggerAnnotation
    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @LoggerAnnotation
    @PostMapping("/register")
    public String registerPost(@Valid RegisterForm registerForm, BindingResult result
//            @RequestParam("email") String email,
//            @RequestParam("name") String name,
//            @RequestParam("password") String passwosd
    ) {
//        User user = new User(name, passwosd, email);
        if(result.hasErrors()){
            return "register";
        }
        User user= registerForm.toUser();
        Integer id = userService.addUser(user);
        if (id != 0) {
            return "redirect:".concat("login");
        }
        return "register";
    }
}
