package com.aviva.javaprograms.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> didNotFindResource(ResourceNotFoundException resourceNotFoundException) {
		return getResponseEntity(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage(),
				"https://www.xyz.com/ResourceNotFoundException.html", new HttpHeaders());
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ExceptionResponse> passedInputIsInvalid(InvalidInputException invalidInputException) {
		return getResponseEntity(HttpStatus.BAD_REQUEST, invalidInputException.getMessage(),
				"https://www.xyz.com/InvalidInputException.html", new HttpHeaders());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> occuredUnknowSituation(Exception exception) {
		return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
				"https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html", new HttpHeaders());
	}

	private ResponseEntity<ExceptionResponse> getResponseEntity(HttpStatus httpStatus, String errorMessage,
			String documentationLink, HttpHeaders httpHeaders) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErroCode(httpStatus.toString());
		exceptionResponse.setErrorMessage(errorMessage);
		exceptionResponse.setDocumentationLink(documentationLink);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, httpHeaders, httpStatus);
	}
}
