package com.skmns.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.skmns.common.mapper")
public class MybatisConfig {
	
	@Bean
	ConfigurationCustomizer mybatisConfigurationCustomizer() {
		return (configuration) -> {

		};
	}
}
