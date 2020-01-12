package club.banyuan.myblog.security;

import club.banyuan.myblog.dao.UserDao;
import club.banyuan.myblog.module.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailServiceImpl implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(MyUserDetailServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =userDao.login(s);
        if(user==null){
            throw new UsernameNotFoundException("User 404");
        }
        return new MyUserDetailImpl(user);
    }
}
