package club.banyuan.myblog.config;

import club.banyuan.myblog.controller.SuccessLoginHandlerController;
import club.banyuan.myblog.security.MyUserDetailImpl;
import club.banyuan.myblog.security.MyUserDetailServiceImpl;
import club.banyuan.myblog.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailServiceImpl myUserDetailService;

    @Autowired
    SuccessLoginHandlerController successLoginHandlerController;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/blogs/{id}", "/register", "/css/**", "/img/**", "favicon.ico").permitAll()
//                .antMatchers("/admin").hasRole("user")
                .anyRequest().authenticated()

                .and().formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login").permitAll()
                .successHandler(successLoginHandlerController)
//                .successForwardUrl("/login")
//                .defaultSuccessUrl("/users/{username}")

//                .and().logout()
//                .logoutUrl("/login").permitAll()
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)

                .and()
                .rememberMe().rememberMeParameter("remember-me");

    }
}
