package com.aviva.javaprograms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.aviva.javaprograms.exception.InvalidInputException;

/**
 * 
 * @author Vishal Mali
 *         <p>
 *         This is a service implementation of {@link JavaProgramsService} which
 *         provides various services related to java programs. Services are
 *         listed below:
 *         <ul>
 *         <li>Fibonacci Series without recursion</li>
 *         <li>Fibonacci Series with recursion</li>
 *         </ul>
 * 
 *         BigInteger is used across the methods, so that we can calculate the
 *         Fibonacci of the big numbers as well
 */
@Service
public class JavaProgramsServiceImpl implements JavaProgramsService {

	private Map<Integer, BigInteger> fibonacciMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Object> getFibonacciSeries(String input) throws InvalidInputException {
		if (!StringUtils.isNumeric(input) || Integer.parseInt(input) == 0) {
			throw new InvalidInputException(input + " passed is not a valid number or position");
		}
		return generateFibonacciSeries(Integer.parseInt(input));
		//return getFibonacciSeriesFromMap(Integer.parseInt(input));
	}

	/**
	 * Gets Fibonacci Series calculated without recursion
	 * <p>
	 * Here Fibonacci series values are stored as map values and their positions as
	 * keys. Finally, map values i.e. Fibonacci series is returned as a list.
	 * 
	 * @param number
	 *            A number upto which Fibonacci Series is to be generated
	 * @return List of Fibonacci Series
	 */
	private List<Object> generateFibonacciSeries(int number) {
		fibonacciMap = new HashMap<>();
		fibonacciMap.put(1, BigInteger.valueOf(1));
		if (number > 1) {
			fibonacciMap.put(2, BigInteger.valueOf(1));
			for (int i = 2; i < number; i++) {
				fibonacciMap.put(i + 1, fibonacciMap.get(i).add(fibonacciMap.get(i - 1)));
			}
		}
		return new ArrayList<>(fibonacciMap.values());
	}
	
	/**
	 * Gets Fibonacci Series calculated recursively
	 * <p>
	 * Here Fibonacci series values are stored as map values and their positions as
	 * keys. So, when recursive call get end all the map values i.e. Fibonacci
	 * series is returned as a list.
	 * 
	 * @param number
	 *            A number upto which Fibonacci Series is to be generated
	 * @return List of Fibonacci Series
	 */
	public List<Object> getFibonacciSeriesFromMap(int number) {
		fibonacciMap = new HashMap<>();
		for (int i = 1; i < number + 1; i++) {
			fibonacciMap.put(i, generateFibonacciSeriesRecursive(i));
		}
		return new ArrayList<>(fibonacciMap.values());
	}

	/**
	 * Gets Fibonacci Series calculated recursively.
	 * 
	 * @param number
	 *            A number upto which Fibonacci Series is to be generated
	 * @return An individual element in Fibonacci Series as a BigInteger
	 */
	private BigInteger generateFibonacciSeriesRecursive(int number) {
		if (number == 0) {
			return BigInteger.ZERO;
		}
		if (number == 1) {
			return BigInteger.ONE;
		}
		// recursive call
		BigInteger value = generateFibonacciSeriesRecursive(number - 2)
				.add(generateFibonacciSeriesRecursive(number - 1));
		return value;
	}
}
