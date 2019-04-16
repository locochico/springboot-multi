package com.skmns.oauth2.config;

import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@MapperScan(basePackages = "com.skmns.common.mapper")
public class MybatisConfig {
	
  @Autowired
  DataSource dataSource;

  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }
	@Bean
	ConfigurationCustomizer mybatisConfigurationCustomizer() {
		return (configuration) -> {

		};
	}
}
