package com.skmns.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.skmns.common.dto.LoginForm;

@Controller
public class LoginController {
  @GetMapping("/login")
  public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
    return "login";
  }

  @GetMapping("/index")
  public String index() {
    return "index";
  }
}
