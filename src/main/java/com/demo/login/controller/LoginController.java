package com.demo.login.controller;

import com.demo.login.model.User;
import com.demo.login.service.UserService;
import com.demo.login.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
  @Autowired
  private UserService userService;

  @Autowired
  private UserValidator userValidator;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");

    return "loginform";
  }

  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
  public String welcome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    User user = new User();
    user.setUsername(userDetails.getUsername());
    user.setPassword(userDetails.getPassword());
    model.addAttribute("user", user);
    return "welcome";
  }

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public String profile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    User user = new User();
    user.setUsername(userDetails.getUsername());
    user.setPassword(userDetails.getPassword());
    model.addAttribute("user", user);
    return "profile";
  }

  @RequestMapping(value = "/modify", method = RequestMethod.POST)
  public String registration(@ModelAttribute("profileForm") User user, BindingResult bindingResult, Model model,
      @AuthenticationPrincipal UserDetails userDetails) {
    userValidator.validate(user, bindingResult);

    if (bindingResult.hasErrors()) {
      return "redirect:/profile?error";
    }

    userService.updatePassword(user);

    //securityService.autologin(member.getUsername(), member.getPassword());

    return "redirect:/welcome";
  }
}
