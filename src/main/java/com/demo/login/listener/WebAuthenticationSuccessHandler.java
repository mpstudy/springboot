package com.demo.login.listener;

import com.demo.login.model.User;
import com.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
//public class LoginSuccess implements ApplicationListener<AuthenticationSuccessEvent>{
public class WebAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  @Autowired
  private UserService userService;

  /*@Override
  public void onApplicationEvent(AuthenticationSuccessEvent event) {
    String username = ((UserDetails)(event.getAuthentication().getPrincipal())).getUsername();
    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)event.getSource();

    User user = new User();
    user.setUsername(token.getName());
    user.setToken(UUID.randomUUID().toString());
    userService.updateToken(user);

    Cookie cookie = new Cookie("login", user.getToken());
  }*/
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
    HttpServletResponse response, Authentication authentication) throws ServletException{
      String username = ((UserDetails)(authentication.getPrincipal())).getUsername();

      User user = new User();
      user.setUsername(username);
      user.setToken(UUID.randomUUID().toString());
      userService.updateToken(user);

      Cookie cookie = new Cookie("mps", user.getToken());
      response.addCookie(cookie);
    }
}
