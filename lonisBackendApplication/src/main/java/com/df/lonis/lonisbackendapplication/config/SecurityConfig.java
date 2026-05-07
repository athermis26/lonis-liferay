package com.df.lonis.lonisbackendapplication.config;

import com.df.lonis.lonisbackendapplication.security.ApiKeyFilter;
import com.df.lonis.lonisbackendapplication.security.ApiKeyProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableConfigurationProperties(ApiKeyProperties.class)
@EnableWebSecurity
public class SecurityConfig {

	private final ApiKeyFilter apiKeyFilter;

	SecurityConfig(ApiKeyFilter apiKeyFilter) {
		this.apiKeyFilter = apiKeyFilter;
	}

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) {
		http
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/**").permitAll()
						.anyRequest().authenticated()
			)
		.addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOriginPatterns(List.of("*"));
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(List.of("Content-Type", "Authorization", "Content-Disposition"));
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/api/**", configuration);
		return source;

	}

//	@Bean
//	public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter(ApiKeyProperties properties) {
//		FilterRegistrationBean<ApiKeyFilter> registration = new FilterRegistrationBean<>();
//		registration.setFilter(new ApiKeyFilter(properties.apiKey()));
//		registration.addUrlPatterns("/api/*");
//		registration.setOrder(1);
//		return registration;
//	}
}
