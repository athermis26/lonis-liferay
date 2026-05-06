package com.df.lonis.ventesrest.internal.backend;

/**
 * Exception levée par {@link BackendHttpClient} en cas d'échec d'appel au backend Spring Boot.
 */
public class BackendException extends RuntimeException {

	private final int statusCode;

	public BackendException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public BackendException(int statusCode, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
