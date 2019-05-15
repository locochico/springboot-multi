package com.skmns.common.util;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodingTest {

  @Test
  public void test() {
    String password = "1234";

    PasswordEncoding passwordEncoding = new PasswordEncoding(new BCryptPasswordEncoder());

    System.out.println("BCrypt 암호화1 : " + passwordEncoding.encode(password));
    System.out.println("BCrypt 암호화2 : " + passwordEncoding.encode(password));
    System.out.println("BCrypt 암호화3 : " + passwordEncoding.encode(password));
    System.out.println("BCrypt 비교: " + passwordEncoding.matches(password, "$2a$10$9HTcRh53bvGEzXqcMlYa0uJIwofFKGPVYJJlzbEfdwjGuNLevnXH2"));

  }

}
