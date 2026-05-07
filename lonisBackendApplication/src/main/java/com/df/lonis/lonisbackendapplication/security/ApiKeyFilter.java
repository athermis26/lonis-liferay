package com.df.lonis.lonisbackendapplication.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

	public static final String HEADER_NAME = "X-API-Key";

	private static final Set<String> WHITELIST = Set.of(
			"/actuator/health",
			"/actuator/info",
			"/swagger-ui",
			"/v3/api-docs"
	);

	private String expectedKey = "L0NIS@2607";

//	private final String expectedKey;
//
//	public ApiKeyFilter(String expectedKey) {
//		this.expectedKey = expectedKey;
//	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getRequestURI();
		return WHITELIST.stream().anyMatch(path::startsWith);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String provided = request.getHeader(HEADER_NAME);
		if (expectedKey == null || expectedKey.isBlank() || !expectedKey.equals(provided)) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().write("{\"error\":\"Unauthorized\",\"message\":\"Missing or invalid API key\"}");
			return;
		}
		chain.doFilter(request, response);
	}
}
