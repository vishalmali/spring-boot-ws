package com.aviva.javaprograms.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vishal Mali
 *         <p>
 *         Utility class for all the java programs
 *         <p>
 *         Java programs are listed below:
 *         <ul>
 *         <li>Fibonacci series without recursion</li>
 *         <li>Fibonacci series with recursion</li>
 *         </ul>
 * 
 *         {@link BigInteger} is used across the methods, so that we can
 *         calculate the Fibonacci of the big numbers as well.
 */
public class JavaProgramsUtils {
	/**
	 * Generates Fibonacci Series without recursion
	 * <p>
	 * Here Fibonacci series is stored as map values and their indexes as keys.
	 * 
	 * @param number
	 *            A number up to which Fibonacci Series is to be generated
	 * @return Map of Fibonacci Series
	 */
	public static Map<Integer, BigInteger> generateFibonacciSeries(int number) {
		Map<Integer, BigInteger> fibonacciMap = new HashMap<>();
		fibonacciMap.put(1, BigInteger.valueOf(1));
		if (number > 1) {
			fibonacciMap.put(2, BigInteger.valueOf(1));
			for (int i = 2; i < number; i++) {
				fibonacciMap.put(i + 1, fibonacciMap.get(i).add(fibonacciMap.get(i - 1)));
			}
		}
		return fibonacciMap;
	}

	/**
	 * Generates Fibonacci Series with recursion
	 * <p>
	 * Here Fibonacci series is stored as map values and their indexes as keys.
	 * 
	 * @param number
	 *            A number up to which Fibonacci Series is to be generated
	 * @return Map of Fibonacci Series
	 */
	public static Map<Integer, BigInteger> generateFibonacciSeriesRecursively(int number) {
		Map<Integer, BigInteger> fibonacciMap = new HashMap<>();
		for (int i = 1; i < number + 1; i++) {
			fibonacciMap.put(i, generateFibonacciNumberRecursively(i));
		}
		return fibonacciMap;
	}

	/**
	 * Generates Fibonacci number recursively.
	 * 
	 * @param number
	 *            A position at which Fibonacci number is to be generated
	 * @return Fibonacci number as a BigInteger
	 */
	private static BigInteger generateFibonacciNumberRecursively(int number) {
		if (number == 0) {
			return BigInteger.ZERO;
		}
		if (number == 1) {
			return BigInteger.ONE;
		}
		// recursive call
		BigInteger value = generateFibonacciNumberRecursively(number - 2)
				.add(generateFibonacciNumberRecursively(number - 1));
		return value;
	}
}
