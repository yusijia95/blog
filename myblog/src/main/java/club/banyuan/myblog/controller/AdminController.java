package club.banyuan.myblog.controller;

import club.banyuan.myblog.annotation.LoggerAnnotation;
import club.banyuan.myblog.module.User;
import club.banyuan.myblog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AdminController {

    private Logger logger= LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    BlogService blogService;

    @LoggerAnnotation
    @GetMapping("/admin")
    public String personalGet(@RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size,
                              Model model,
                              HttpSession session){
        PageInfo pageInfo=blogService.selectBlogByUserName(page.orElse(1),size.orElse(5),((User)session.getAttribute("USER_MESSAGE")).getName());
        model.addAttribute("blogs",pageInfo);
        session.setAttribute("blogs",pageInfo);
        model.addAttribute("user",session.getAttribute("USER_MESSAGE"));
        logger.info("model: {}",model);
        return "admin";
    }
}
