package com.skmns.oauth2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.skmns.common.mapper.AccountMapper;
import com.skmns.common.mapper.AccountRoleMapper;
import com.skmns.common.model.Account;
import com.skmns.common.model.SecurityAccount;


@Service
public class LoginUserDetailsService implements UserDetailsService {
  @Autowired
  AccountMapper accountMapper;

  @Autowired
  AccountRoleMapper accountRoleMapper;

  @Override
  public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {

    Account account = accountMapper.select(accountName);

    if (account != null) {
      account.setAuthorities(makeGrantedAuthority(accountRoleMapper.selectAuthority(account.getNo())));
      return new SecurityAccount(account);
    }

    return new SecurityAccount();
  }

  private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
    List<GrantedAuthority> list = new ArrayList<>();
    roles.forEach(role -> list.add(new SimpleGrantedAuthority(role)));
    return list;
  }
}


