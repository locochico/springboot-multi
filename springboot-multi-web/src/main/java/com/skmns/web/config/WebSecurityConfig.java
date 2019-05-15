package com.skmns.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.skmns.web.security.handlers.LoginFailureHandler;
import com.skmns.web.security.handlers.LoginSuccessHandler;
import com.skmns.web.security.service.UserAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /*
   * @Autowired CustomMemberService customMemberService;
   */

  @Autowired
  private UserAuthenticationProvider authenticationProvider;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationSuccessHandler successHandler() {
    return new LoginSuccessHandler("/");
  }

  @Bean
  public AuthenticationFailureHandler failureHandler() {
    return new LoginFailureHandler();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/sample/**", "/resources/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin()
    //  .successHandler(successHandler()).failureHandler(failureHandler());
    
    http.csrf().disable().authorizeRequests()
    .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
    .antMatchers("/auth/admin/**").hasRole("ADMIN")
    .antMatchers("/auth/**").hasAnyRole("ADMIN", "USER")
    .anyRequest().authenticated();

    http.formLogin().successHandler(successHandler()).failureHandler(failureHandler())
        .loginPage("/login") // default
        .loginProcessingUrl("/authenticate")
        .failureUrl("/login?error") // default
        .defaultSuccessUrl("/users")
        .usernameParameter("name")
        .passwordParameter("password")
        .permitAll();
    
    http.logout()
        .logoutUrl("/logout") // default
        .logoutSuccessUrl("/login")
        .permitAll();
    
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider);
    // auth.userDetailsService(customMemberService).passwordEncoder(passwordEncoder());
  }

}
