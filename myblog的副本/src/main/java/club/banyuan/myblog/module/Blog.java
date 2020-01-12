package club.banyuan.myblog.module;

import club.banyuan.myblog.controller.CommentController;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Blog implements Serializable {
    private Integer id;
    private String title;
    private Timestamp createdTime;
//    private Integer userId;
    private String content;
    private User user;
    private List<Comment> comment;

    public Blog() {
    }

    public Blog(String title, Timestamp createdTime, User user, String content) {
        this.title = title;
        this.createdTime = createdTime;
        this.user = user;
        this.content = content;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdTime=" + createdTime +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", comment=" + comment +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
