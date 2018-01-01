package com.aviva.javaprograms.service;

import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.aviva.javaprograms.dto.Response;
import com.aviva.javaprograms.exception.InvalidInputException;

public class JavaProgramsServiceImplTest {
	private JavaProgramsServiceImpl javaProgramsServiceImpl;

	@Before
	public void setUp() {
		javaProgramsServiceImpl = new JavaProgramsServiceImpl();
	}

	@Test(expected = InvalidInputException.class)
	public void testGetFibonacciSeriesForException() {
		javaProgramsServiceImpl.getFibonacciSeries("foobar");
	}

	@Test
	public void testGetFibonacciSeries() {
		List<BigInteger> fibonacciList = new ArrayList<>();
		fibonacciList.add(BigInteger.valueOf(1));
		fibonacciList.add(BigInteger.valueOf(1));
		fibonacciList.add(BigInteger.valueOf(2));
		fibonacciList.add(BigInteger.valueOf(3));
		fibonacciList.add(BigInteger.valueOf(5));
		fibonacciList.add(BigInteger.valueOf(8));

		List<BigInteger> actualList = javaProgramsServiceImpl.getFibonacciSeries("6");

		assertThat(actualList, CoreMatchers.is(fibonacciList));
	}

	@Test
	public void testGetFibonacciSeriesFromMap() {
		Map<Integer, BigInteger> fibonacciMap = new HashMap<>();
		fibonacciMap.put(1, BigInteger.valueOf(1));
		fibonacciMap.put(2, BigInteger.valueOf(1));
		fibonacciMap.put(3, BigInteger.valueOf(2));
		fibonacciMap.put(4, BigInteger.valueOf(3));
		fibonacciMap.put(5, BigInteger.valueOf(5));
		fibonacciMap.put(6, BigInteger.valueOf(8));

		Map<Integer, BigInteger> actualMap = javaProgramsServiceImpl.getFibonacciSeriesWithIndexes("6");

		assertThat(actualMap, CoreMatchers.is(fibonacciMap));
	}

	@Test
	public void testGetFibonacciSeriesWithPagination() {
		Map<Integer, BigInteger> expectedMap = new HashMap<>();
		expectedMap.put(5, BigInteger.valueOf(5));
		expectedMap.put(6, BigInteger.valueOf(8));
		expectedMap.put(7, BigInteger.valueOf(13));
		expectedMap.put(8, BigInteger.valueOf(21));

		List<BigInteger> fibonacciList = new ArrayList<>();
		fibonacciList.add(BigInteger.valueOf(5));
		fibonacciList.add(BigInteger.valueOf(8));
		fibonacciList.add(BigInteger.valueOf(13));
		fibonacciList.add(BigInteger.valueOf(21));

		Response expectedResponse = new Response();
		expectedResponse.setInput("9");
		expectedResponse.setPageNo("2");
		expectedResponse.setRecordsPerPage("4");
		expectedResponse.setFibonacciSeriesWithIndexes(expectedMap);
		expectedResponse.setFibonacciSeries(fibonacciList);

		Response actualResponse = javaProgramsServiceImpl.getFibonacciSeriesWithPagination("9", "2", "4");

		assertThat(actualResponse.getFibonacciSeries(), CoreMatchers.is(expectedResponse.getFibonacciSeries()));
		assertThat(actualResponse.getFibonacciSeriesWithIndexes(),
				CoreMatchers.is(expectedResponse.getFibonacciSeriesWithIndexes()));

	}
}
