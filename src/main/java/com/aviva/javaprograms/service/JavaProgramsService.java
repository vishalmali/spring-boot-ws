package com.aviva.javaprograms.service;

import java.util.List;

import com.aviva.javaprograms.exception.InvalidInputException;

/**
 * 
 * @author Vishal Mali
 *         <p>
 *         This is a service layer which provides various services related to
 *         java programs. Services are listed below:
 *         <ul>
 *         <li>Fibonacci Series</li>
 *         </ul>
 */
public interface JavaProgramsService {
	/**
	 * Gets Fibonacci Series upto the given number
	 * 
	 * @param input
	 *            A number in String format upto which Fibonacci Series is to be
	 *            generated
	 * @return List containing Fibonacci series
	 * @throws InvalidInputException
	 *             If input provided is invalid
	 */
	List<Object> getFibonacciSeries(String input) throws InvalidInputException;
}
