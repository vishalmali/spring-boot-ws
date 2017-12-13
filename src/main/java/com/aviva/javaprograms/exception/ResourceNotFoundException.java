package com.aviva.javaprograms.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -467266406462994395L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
