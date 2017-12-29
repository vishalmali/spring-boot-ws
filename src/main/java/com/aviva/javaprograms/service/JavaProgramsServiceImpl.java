package com.aviva.javaprograms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.aviva.javaprograms.dto.Response;
import com.aviva.javaprograms.exception.InvalidInputException;
import com.aviva.javaprograms.util.JavaProgramsUtils;

/**
 * @author Vishal Mali
 *         <p>
 *         This is a service implementation of {@link JavaProgramsService} which
 *         provides various services related to java programs. Services are
 *         listed below:
 *         <ul>
 *         <li>Fibonacci Series</li>
 *         <li>Fibonacci Series with index</li>
 *         </ul>
 * 
 *         {@link BigInteger} is used across the methods, so that Fibonacci
 *         series of the big numbers can be calculated.
 */
@Service
public class JavaProgramsServiceImpl implements JavaProgramsService {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BigInteger> getFibonacciSeries(String input) {
		validateInput(input);
		return new ArrayList<>(JavaProgramsUtils.generateFibonacciSeries(Integer.parseInt(input)).values());
		// TODO: Uncomment the below statement and comment the above statement to generate Fibonacci Series recursively.
		// return new ArrayList<>(JavaProgramsUtils.generateFibonacciSeriesRecursively(Integer.parseInt(input)).values());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, BigInteger> getFibonacciSeriesWithIndexes(String input) {
		validateInput(input);
		return JavaProgramsUtils.generateFibonacciSeries(Integer.parseInt(input));
		// TODO: Uncomment the below statement and comment the above statement to generate Fibonacci Series recursively.
		// return JavaProgramsUtils.generateFibonacciSeriesRecursively(Integer.parseInt(input));
	}

	@Override
	public Response getFibonacciSeriesWithPagination(String input, String pageNo, String recordsPerPage) {
		
		Response response = new Response();
		response.setInput(input);
		response.setPageNo(pageNo);
		response.setRecordsPerPage(recordsPerPage);
		response.setFibonacciSeries(new ArrayList<>(JavaProgramsUtils.generateFibonacciSeries(Integer.parseInt(input)).values()));
		response.setFibonacciSeriesWithIndexes(JavaProgramsUtils.generateFibonacciSeries(Integer.parseInt(input)));
		
		return response;
	}
	
	/**
	 * Validates input string
	 * 
	 * @param input
	 *            String to be validated
	 * @exception throws
	 *                {@link InvalidInputException} if passed input string is not
	 *                numeric or zero
	 */
	private void validateInput(String input) {
		if (!StringUtils.isNumeric(input) || Integer.parseInt(input) == 0) {
			throw new InvalidInputException("'" + input + "'" + " passed is not a valid number or position");
		}
	}
}
