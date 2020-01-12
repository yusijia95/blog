package club.banyuan.myblog.dao;

import club.banyuan.myblog.module.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    Comment selectCommentById(Integer id);

    List<Comment> selectCommentByBlogId(Integer id);

    boolean addComment(Comment comment);
}
