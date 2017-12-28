package com.aviva.javaprograms.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Vishal Mali
 *         <p>
 *         Exception handler class which handles all the exceptions.
 *         <p>
 *         Below are the exceptions handled by this class: <ui>
 *         <li>{@link ResourceNotFoundException} - Thrown when resource is not
 *         found</li>
 *         <li>{@link InvalidInputException} - Thrown when input provided is
 *         invalid</li>
 *         <li>{@link Exception} - Thrown when any other exception occurred</li>
 *         </ui>
 */
@ControllerAdvice
public class ExceptionHandlingController {
	/**
	 * Gets called when desired resource is not found
	 * 
	 * @param resourceNotFoundException
	 *            exception of type {@link ResourceNotFoundException}
	 * @return Exception response composed in {@link ResponseEntity}
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> didNotFindResource(ResourceNotFoundException resourceNotFoundException) {
		return getResponseEntity(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage(),
				"https://www.xyz.com/ResourceNotFoundException.html", new HttpHeaders());
	}

	/**
	 * Gets called when input provided is invalid
	 * 
	 * @param invalidInputException
	 *            exception of type {@link InvalidInputException}
	 * @return Exception response composed in {@link ResponseEntity}
	 */
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ExceptionResponse> passedInputIsInvalid(InvalidInputException invalidInputException) {
		return getResponseEntity(HttpStatus.BAD_REQUEST, invalidInputException.getMessage(),
				"https://www.xyz.com/InvalidInputException.html", new HttpHeaders());
	}

	/**
	 * Gets called when unknown error situation occurs
	 * 
	 * @param exception
	 *            of type {@link Exception}
	 * @return Exception response composed in {@link ResponseEntity}
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> occuredUnknowSituation(Exception exception) {
		return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
				"https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html", new HttpHeaders());
	}

	/**
	 * Gets Response Entity object filled with required data
	 * 
	 * @param httpStatus
	 *            Enumeration of HTTP status codes {@link HttpStatus}.
	 * @param errorMessage
	 *            Message explaining the error details
	 * @param documentationLink
	 *            Link of documentation for the raised exception class
	 * @param httpHeaders
	 *            Represents HTTP request and response headers{@link HttpHeaders}
	 * @return Exception response composed in {@link ResponseEntity}
	 */
	private ResponseEntity<ExceptionResponse> getResponseEntity(HttpStatus httpStatus, String errorMessage,
			String documentationLink, HttpHeaders httpHeaders) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErroCode(httpStatus.toString());
		exceptionResponse.setErrorMessage(errorMessage);
		exceptionResponse.setDocumentationLink(documentationLink);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, httpHeaders, httpStatus);
	}
}
