package com.df.lonis.reseaurest.internal.backend;

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
