package club.banyuan.myblog.service;

import club.banyuan.myblog.module.Blog;
import com.github.pagehelper.PageInfo;


public interface BlogService {
    Blog selectBlogById(Integer id);

    PageInfo selectBlogByUserName(Integer page, Integer size, String name);

    boolean addBlog(Blog blog);

    boolean deleteBlogById(Integer id);
}
