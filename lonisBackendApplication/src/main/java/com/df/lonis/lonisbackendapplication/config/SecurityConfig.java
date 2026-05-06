package com.df.lonis.lonisbackendapplication.config;

import com.df.lonis.lonisbackendapplication.security.ApiKeyFilter;
import com.df.lonis.lonisbackendapplication.security.ApiKeyProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApiKeyProperties.class)
public class SecurityConfig {

	@Bean
	public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter(ApiKeyProperties properties) {
		FilterRegistrationBean<ApiKeyFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new ApiKeyFilter(properties.apiKey()));
		registration.addUrlPatterns("/api/*");
		registration.setOrder(1);
		return registration;
	}
}
