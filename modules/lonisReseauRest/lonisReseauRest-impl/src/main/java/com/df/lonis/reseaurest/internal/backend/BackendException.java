package com.df.lonis.reseaurest.internal.backend;

/**
 * Levée par {@link BackendHttpClient} en cas d'échec d'appel au backend Spring Boot.
 *
 * <p>Conserve le code HTTP retourné par le backend ainsi que le body brut JSON
 * pour que {@code BackendExceptionMapper} puisse le renvoyer tel quel au client.</p>
 */
public class BackendException extends RuntimeException {

	private final int statusCode;
	private final String body;

	public BackendException(int statusCode, String message) {
		this(statusCode, message, null, null);
	}

	public BackendException(int statusCode, String message, Throwable cause) {
		this(statusCode, message, null, cause);
	}

	public BackendException(int statusCode, String message, String body, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
		this.body = body;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getBody() {
		return body;
	}
}
