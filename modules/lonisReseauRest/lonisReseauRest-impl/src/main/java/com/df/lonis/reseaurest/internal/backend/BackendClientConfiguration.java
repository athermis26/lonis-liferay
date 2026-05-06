package com.df.lonis.reseaurest.internal.backend;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
		id = "com.df.lonis.reseaurest.internal.backend.BackendClientConfiguration",
		localization = "content/Language",
		name = "Lonis Reseau Backend Client Configuration"
)
public interface BackendClientConfiguration {

	@Meta.AD(deflt = "http://localhost:9090", description = "URL de base du backend Spring Boot",
			name = "Base URL", required = false)
	String baseUrl();

	@Meta.AD(deflt = "dev-change-me", description = "Clé API X-API-Key",
			name = "API Key", required = false)
	String apiKey();

	@Meta.AD(deflt = "5000", description = "Timeout connexion (ms)",
			name = "Connect Timeout (ms)", required = false)
	int connectTimeoutMs();

	@Meta.AD(deflt = "15000", description = "Timeout lecture (ms)",
			name = "Read Timeout (ms)", required = false)
	int readTimeoutMs();
}
