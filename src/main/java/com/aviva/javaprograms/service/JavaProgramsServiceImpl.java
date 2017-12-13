package com.aviva.javaprograms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.aviva.javaprograms.exception.InvalidInputException;

@Service
public class JavaProgramsServiceImpl implements JavaProgramsService {

	private Map<Integer, BigInteger> fiboMap;

	@Override
	public List<Object> getFibonacciSeries(String input) throws InvalidInputException {
		if (!StringUtils.isNumeric(input) || Integer.parseInt(input) == 0) {
			throw new InvalidInputException(input + " passed is not a valid number or position");
		}
		// return generateFibonacciSeries(Integer.parseInt(input));
		return getFibonacciSeriesFromMap(Integer.parseInt(input));
	}

	private List<Object> generateFibonacciSeries(int number) {
		fiboMap = new HashMap<>();
		fiboMap.put(1, BigInteger.valueOf(1));
		if (number > 1) {
			fiboMap.put(2, BigInteger.valueOf(1));
			for (int i = 2; i < number; i++) {
				fiboMap.put(i + 1, fiboMap.get(i).add(fiboMap.get(i - 1)));
			}
		}
		return new ArrayList<>(fiboMap.values());
	}

	public List<Object> getFibonacciSeriesFromMap(int number) {
		fiboMap = new HashMap<>();
		for (int i = 1; i < number + 1; i++) {
			fiboMap.put(i, generateFibonacciSeriesRecursive(i));
		}
		return new ArrayList<>(fiboMap.values());
	}

	public BigInteger generateFibonacciSeriesRecursive(int n) {
		if (n == 0) {
			return BigInteger.ZERO;
		}
		if (n == 1) {
			return BigInteger.ONE;
		}
		BigInteger value = generateFibonacciSeriesRecursive(n - 2).add(generateFibonacciSeriesRecursive(n - 1));
		return value;
	}
}
