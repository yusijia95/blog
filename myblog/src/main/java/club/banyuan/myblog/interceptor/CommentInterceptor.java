package club.banyuan.myblog.interceptor;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommentInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getParameter("content")!=null){
            HttpSession session=request.getSession();
            session.setAttribute("content",request.getParameter("content"));
        }
        return true;
    }
}
