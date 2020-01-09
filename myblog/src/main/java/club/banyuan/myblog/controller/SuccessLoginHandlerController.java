package club.banyuan.myblog.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class SuccessLoginHandlerController implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
       DefaultSavedRequest savedRequest=(DefaultSavedRequest) httpServletRequest.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
       if(savedRequest!=null){
           String parameter=savedRequest.getQueryString();
           String redirectUrl=savedRequest.getRedirectUrl();
           if(parameter!=null){
              redirectUrl=redirectUrl+"?"+parameter;
           }
           System.out.println("一次");
           httpServletResponse.sendRedirect(redirectUrl);
       }else {
           String username = authentication.getName();
           System.out.println(username);
           httpServletResponse.sendRedirect("/users/" + URLEncoder.encode(username, "UTF-8"));
       }
    }
}
