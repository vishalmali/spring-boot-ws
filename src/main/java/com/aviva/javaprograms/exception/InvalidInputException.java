package com.aviva.javaprograms.exception;

/**
 * @author Vishal Mali
 *         <p>
 *         Customized exception class, used when input provided is invalid
 */
public class InvalidInputException extends Exception {
	private static final long serialVersionUID = -9145855941447659729L;

	public InvalidInputException(String message) {
		super(message);
	}
}
