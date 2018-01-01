package com.aviva.javaprograms.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.aviva.javaprograms.dto.Response;

/**
 * @author Vishal Mali
 *         <p>
 *         This is a service interface layer which provides various services
 *         related to java programs. Services are listed below:
 *         <ul>
 *         <li>Fibonacci Series</li>
 *         <li>Fibonacci Series with index positions</li>
 *         </ul>
 * 
 *         {@link BigInteger} is used across the methods, so that we can
 *         calculate the Fibonacci of the big numbers as well.
 */
public interface JavaProgramsService {
	/**
	 * Gets Fibonacci Series up to the given number
	 * 
	 * @param input
	 *            A number in String format up to which Fibonacci Series is to be
	 *            generated
	 * @return List of Fibonacci series
	 */
	List<BigInteger> getFibonacciSeries(String input);

	/**
	 * Gets Fibonacci Series up to the given number with their indexes
	 * <p>
	 * Here Fibonacci series is stored as map values and their indexes as keys.
	 * 
	 * @param input
	 *            A number in String format up to which Fibonacci Series is to be
	 *            generated
	 * @return Map of Fibonacci Series
	 */
	Map<Integer, BigInteger> getFibonacciSeriesWithIndexes(String input);

	/**
	 * Gets Fibonacci Series according to the pagination parameters
	 * 
	 * @param input
	 *            A number in String format up to which Fibonacci Series is to be
	 *            generated
	 * @param pageNo Requested page number
	 * @param recordsPerPage Number of records per page
	 * @return Paginated Fibonnaci series encapsulated in Response class object
	 */
	Response getFibonacciSeriesWithPagination(String input, String pageNo, String recordsPerPage);
}
