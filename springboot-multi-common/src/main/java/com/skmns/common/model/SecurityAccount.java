package com.skmns.common.model;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SecurityAccount extends User {
  private static final long serialVersionUID = 1L;

  public SecurityAccount(Account account) {
    super(account.getAccount(), account.getPassword(), account.getAuthorities());
  }

  public SecurityAccount() {
    super("-", "-", new ArrayList<GrantedAuthority>());
  }
}
