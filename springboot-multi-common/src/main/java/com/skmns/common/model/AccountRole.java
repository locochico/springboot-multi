package com.skmns.common.model;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("accountRole")
public class AccountRole {
  private Long no;
  private String role;
}
