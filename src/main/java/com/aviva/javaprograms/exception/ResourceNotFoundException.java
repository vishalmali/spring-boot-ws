package com.aviva.javaprograms.exception;

/**
 * @author Vishal Mali
 *         <p>
 *         Customized exception class, used when desired resource is not found
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -467266406462994395L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
