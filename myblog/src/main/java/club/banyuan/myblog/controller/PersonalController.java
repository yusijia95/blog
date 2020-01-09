package club.banyuan.myblog.controller;

import club.banyuan.myblog.annotation.LoggerAnnotation;
import club.banyuan.myblog.service.BlogService;
import club.banyuan.myblog.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class PersonalController {

    private Logger logger= LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    BlogService blogService;

    @LoggerAnnotation
    @GetMapping("/users/{username}")
    public String personalGet(@PathVariable("username") String username,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size,
                              Model model,
                              HttpSession session){
        PageInfo pageInfo=blogService.selectBlogByUserName(page.orElse(1),size.orElse(5),username);
        model.addAttribute("blogs",pageInfo);
//        session.setAttribute("blogs",pageInfo);
        model.addAttribute("user",session.getAttribute("USER_MESSAGE"));
        session.setAttribute("USERNAME",username);
        logger.info("model: {}",model);
        return "list";
    }

}
