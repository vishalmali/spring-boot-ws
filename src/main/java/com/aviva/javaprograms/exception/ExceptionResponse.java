package com.aviva.javaprograms.exception;

/**
 * @author Vishal Mali
 *         <p>
 *         Exception response containing fields to hold relevant information
 *         about errors that happen during REST calls
 */
public class ExceptionResponse {
	private String erroCode;
	private String errorMessage;
	// To share a particular Exception class documentation.
	private String documentationLink;

	public String getErroCode() {
		return erroCode;
	}

	public void setErroCode(String erroCode) {
		this.erroCode = erroCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDocumentationLink() {
		return documentationLink;
	}

	public void setDocumentationLink(String documentationLink) {
		this.documentationLink = documentationLink;
	}
}
