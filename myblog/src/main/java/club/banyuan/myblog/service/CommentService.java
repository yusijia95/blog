package club.banyuan.myblog.service;

import club.banyuan.myblog.module.Comment;
import club.banyuan.myblog.module.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {
    Comment selectCommentById(Integer id);

    List<Comment> selectCommentByBlogId(Integer id);

    boolean addComment(Comment comment);
}
