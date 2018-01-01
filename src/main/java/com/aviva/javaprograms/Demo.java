package com.aviva.javaprograms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Demo {


	private Map<Integer, BigInteger> fibonacciMap;
	
	public static void main(String[] args) {
/*		List<Object> fibonacciSeries = new Demo().generateFibonacciSeries(Integer.parseInt("30"));
		//List<Object> fibonacciSeries = new Demo().getFibonacciSeriesFromMap(Integer.parseInt("30"));
		System.out.println(fibonacciSeries);*/
		
		TreeMap<Integer, BigInteger> map = new TreeMap<>();
		map.put(1, BigInteger.valueOf(1));
		map.put(2, BigInteger.valueOf(1));
		map.put(3, BigInteger.valueOf(2));
		map.put(4, BigInteger.valueOf(3));
		map.put(5, BigInteger.valueOf(5));
		
		Map<Integer, BigInteger> map1 = new HashMap<>();
		map1.put(1, BigInteger.valueOf(1));
		map1.put(2, BigInteger.valueOf(1));
		map1.put(3, BigInteger.valueOf(2));
		map1.put(4, BigInteger.valueOf(3));
		map1.put(5, BigInteger.valueOf(5));
		
		System.out.println(map);
		System.out.println(map1);
		
		 Set<Entry<Integer, BigInteger>>  entySet = map.entrySet();
		 
		 for (Entry entry : entySet) {
			 System.out.println("Key = " + entry.getKey() + " Valye = " + entry.getValue());
		}
		 
		 Set<Entry<Integer, BigInteger>>  entySet1 = map1.entrySet();
		 
		 for (Entry entry : entySet1) {
			 System.out.println("Key = " + entry.getKey() + " Valye = " + entry.getValue());
		}
	
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
