package com.skmns.web.security.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.skmns.common.model.User;
import com.skmns.common.util.PasswordEncoding;
import com.skmns.web.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
  
  @Autowired
  private UserService userService;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String id = authentication.getName();
    String password = (String) authentication.getCredentials();

    log.info("password: {}", password);
    log.info("bCryptPasswordEncoding password: {}", PasswordEncoding.bCryptPasswordEncoding().encode(password));
    PasswordEncoding passwordEncoding = new PasswordEncoding(new BCryptPasswordEncoder());

    User user = userService.authenticate(id);
    log.info("user.getPassword()= {}", user.getPassword());
    if (user == null || !passwordEncoding.matches(password, user.getPassword()))
      throw new BadCredentialsException("Login Error !!");

    user.setPassword(null);

    ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    return new UsernamePasswordAuthenticationToken(user, null, authorities);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

}
