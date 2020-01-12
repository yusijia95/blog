//package club.banyuan.myblog.config;
//
//import club.banyuan.myblog.interceptor.CommentInterceptor;
//import club.banyuan.myblog.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration comment = registry.addInterceptor(new CommentInterceptor());
//        InterceptorRegistration login = registry.addInterceptor(new LoginInterceptor());
//        comment.addPathPatterns("/blogs/{id}/comments");
//        login.addPathPatterns("/blogs/{id}/comments").addPathPatterns("/admin");
//    }
//}
