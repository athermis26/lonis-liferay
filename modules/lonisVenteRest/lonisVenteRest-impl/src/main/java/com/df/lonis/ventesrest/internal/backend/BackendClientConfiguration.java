package com.df.lonis.ventesrest.internal.backend;

import aQute.bnd.annotation.metatype.Meta;

/**
 * Configuration OSGi pour le client HTTP du backend Spring Boot.
 *
 * Le fichier de configuration sera déposé dans :
 *   configs/local/osgi/configs/com.df.lonis.ventesrest.internal.backend.BackendClientConfiguration.config
 */
@Meta.OCD(
		id = "com.df.lonis.ventesrest.internal.backend.BackendClientConfiguration",
		localization = "content/Language",
		name = "Lonis Backend Client Configuration"
)
public interface BackendClientConfiguration {

	@Meta.AD(
			deflt = "http://localhost:9090",
			description = "URL de base du backend Spring Boot",
			name = "Base URL",
			required = false
	)
	String baseUrl();

	@Meta.AD(
			deflt = "dev-change-me",
			description = "Clé API envoyée dans l'en-tête X-API-Key",
			name = "API Key",
			required = false
	)
	String apiKey();

	@Meta.AD(
			deflt = "5000",
			description = "Timeout de connexion en millisecondes",
			name = "Connect Timeout (ms)",
			required = false
	)
	int connectTimeoutMs();

	@Meta.AD(
			deflt = "15000",
			description = "Timeout de lecture en millisecondes",
			name = "Read Timeout (ms)",
			required = false
	)
	int readTimeoutMs();
}
