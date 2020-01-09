package club.banyuan.myblog.controller;

import club.banyuan.myblog.annotation.LoggerAnnotation;
import club.banyuan.myblog.module.Comment;
import club.banyuan.myblog.module.User;
import club.banyuan.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @LoggerAnnotation
    @PostMapping("/blogs/{id}/comments")
    public String commentPost(@PathVariable("id") Integer id,
                              @RequestParam("page") Integer page,
                              HttpSession session, HttpServletRequest request, Model model) {
        String string = (String)session.getAttribute("content");
        Comment comment = new Comment();
        comment.setContent(string);
        comment.setBlogId(id);
        comment.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        User user = (User) session.getAttribute("USER_MESSAGE");
        comment.setUserId(user.getId());
        commentService.addComment(comment);
        Integer number=page;
        return "redirect:/blogs/"+page+"".concat("?page="+page);
    }
}
