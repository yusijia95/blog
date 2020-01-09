//package club.banyuan.myblog.interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.net.URLEncoder;
//
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//    private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (request.getSession().getAttribute("USER_MESSAGE") != null) {
//            return true;
//        }
//        response.sendRedirect("/login?next="+ URLEncoder.encode("".concat(request.getRequestURI()),"utf-8"));
//        return false;
//    }
//}
