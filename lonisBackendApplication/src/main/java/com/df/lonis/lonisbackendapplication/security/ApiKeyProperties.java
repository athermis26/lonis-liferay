package com.df.lonis.lonisbackendapplication.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "lonis.security")
public record ApiKeyProperties(String apiKey) {
}
