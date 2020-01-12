package club.banyuan.myblog.dao;

import club.banyuan.myblog.module.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogDaoTest {

    @Autowired
    BlogDao blogDao;

    @Test
    void selectUserById() {
        System.out.println("test");
        Blog blog=blogDao.selectUserById(7);
        System.out.println(blog.toString());
    }

    @Test
    void selectCommentById(){
        System.out.println("testComment");
        Blog blog=blogDao.selectCommentById(7);
        System.out.println(blog.toString());
    }
}