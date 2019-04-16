package com.skmns.common.model;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SecurityMember extends User {

  private static final long serialVersionUID = 1L;

  private String ip;

  public SecurityMember(Member member) {
    super(member.getUsername(), member.getPassword(), member.getAuthorities());
  }

  public SecurityMember() {
    super("-", "-", new ArrayList<GrantedAuthority>());
  }

}
