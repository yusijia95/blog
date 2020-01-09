package club.banyuan.myblog.service;

import club.banyuan.myblog.module.User;

public interface UserService {
    User loginService(String email, String name);

    Integer addUser(User user);
}
