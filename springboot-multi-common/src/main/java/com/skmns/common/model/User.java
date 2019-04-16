package com.skmns.common.model;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("user")
public class User {
	private int id;
  private String name;
  private String password;
}
