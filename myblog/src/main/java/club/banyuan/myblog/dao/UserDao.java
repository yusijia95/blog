package club.banyuan.myblog.dao;

import club.banyuan.myblog.module.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User login(String name);

    Integer addUser(User user);
}
