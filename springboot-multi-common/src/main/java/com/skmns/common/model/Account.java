package com.skmns.common.model;

import java.util.Collection;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import lombok.Data;

@Data
@Alias("account")
public class Account {
  private Long no;
  private String account;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;
}
