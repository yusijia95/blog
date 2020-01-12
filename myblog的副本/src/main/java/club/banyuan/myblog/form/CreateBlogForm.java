package club.banyuan.myblog.form;

import club.banyuan.myblog.module.Blog;

import javax.validation.constraints.Size;

public class CreateBlogForm {
    @Size(min = 1,message = "标题输入错误")
    private String title;
    @Size(min = 20,message = "内容输入错误")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog toBlog(){
        Blog blog=new Blog(this.title,this.content);
        return blog;
    }
}
