package club.banyuan.myblog.controller;


import club.banyuan.myblog.annotation.LoggerAnnotation;
import club.banyuan.myblog.form.CreateBlogForm;
import club.banyuan.myblog.module.Blog;
import club.banyuan.myblog.module.User;
import club.banyuan.myblog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Optional;

@Controller
public class DeleteBlogController {

    private Logger logger= LoggerFactory.getLogger(DeleteBlogController.class);

    @Autowired
    BlogService blogService;

    @LoggerAnnotation
    @PostMapping("/deleteBlog/{id}")
    public String createBlogPost(@PathVariable("id") Integer id,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 HttpSession session, Model model){
        blogService.deleteBlogById(id);
        PageInfo pageInfo=blogService.selectBlogByUserName(page.orElse(1),size.orElse(5),((User)session.getAttribute("USER_MESSAGE")).getName());
        model.addAttribute("blogs",pageInfo);
        return "redirect:/admin";
    }
}
