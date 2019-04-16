package com.skmns.api.security.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.skmns.common.mapper.MemberMapper;
import com.skmns.common.model.Member;
import com.skmns.common.model.SecurityMember;

// @Service
public class CustomMemberService implements UserDetailsService {

  private static final String ROLE_PREFIX = "ROLE_";

  @Autowired
  MemberMapper memberMapper;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    Member member = memberMapper.selectMember(userName);

    if (member != null) {
      member.setAuthorities(makeGrantedAuthority(memberMapper.selectAuthority(userName)));
      return new SecurityMember(member);
    }

    return new SecurityMember();
  }

  private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
    List<GrantedAuthority> list = new ArrayList<>();
    roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
    return list;
  }
}
