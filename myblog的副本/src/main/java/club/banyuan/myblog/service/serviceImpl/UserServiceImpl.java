package club.banyuan.myblog.service.serviceImpl;

import club.banyuan.myblog.annotation.LoggerAnnotation;
import club.banyuan.myblog.dao.UserDao;
import club.banyuan.myblog.module.User;
import club.banyuan.myblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    @LoggerAnnotation
    @Override
    public User loginService(String name, String password) {
        User user = userDao.login(name);
//        logger.info("userService登录信息： {},{}",name,password);
        if (user != null) {
            //可以返回密码错误
            return (password.equals(user.getPassword())) ? user : null;
        }
        //可以返回账号错误
        return null;
    }

    @Override
    public User selectUserByName(String name) {
        return userDao.login(name);
    }

    @Override
    public Integer addUser(User user) {
        if(user!=null){
            return userDao.addUser(user);
        }
        return 0;
    }
}
