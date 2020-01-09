package club.banyuan.myblog.module;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Comment implements Serializable {
    private Integer id;
    private Timestamp createdTime;
    private Integer userId;
    private Integer blogId;
    private String content;

    public Comment() {
    }

    public Comment(Timestamp createdTime, Integer userId, Integer blogId, String content) {
        this.createdTime = createdTime;
        this.userId = userId;
        this.blogId = blogId;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", createdTime='" + createdTime + '\'' +
                ", userId=" + userId +
                ", blogId=" + blogId +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public void setCommenter(User user) {
//
//    }
//
//    public void setBlog(Blog blog) {
//
//    }
}
