package com.aviva.javaprograms.service;

import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.aviva.javaprograms.exception.InvalidInputException;

@RunWith(SpringRunner.class)
public class JavaProgramsServiceImplTest {

	
	private JavaProgramsServiceImpl javaProgramsServiceImpl;

	@Before
	public void setUp() {
		javaProgramsServiceImpl = new JavaProgramsServiceImpl();
	}

	@Test
	public void testGetFibonacciSeries() throws InvalidInputException {
		Object[] array = new Object[] { BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2),
				BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(8) };
		List<Object> actualList = javaProgramsServiceImpl.getFibonacciSeries("6");
		assertThat(actualList, CoreMatchers.is(Arrays.asList(array)));
	}

	@Test
	public void testGetFibonacciSeriesFromMap() {
		Map<Integer, Object> fibonacciMap = new HashMap<>();
		fibonacciMap.put(1, BigInteger.valueOf(1));
		fibonacciMap.put(2, BigInteger.valueOf(1));
		fibonacciMap.put(3, BigInteger.valueOf(2));
		fibonacciMap.put(4, BigInteger.valueOf(3));
		fibonacciMap.put(5, BigInteger.valueOf(5));
		fibonacciMap.put(6, BigInteger.valueOf(8));
		List<Object> expectedList = new ArrayList<>();
		expectedList.addAll(fibonacciMap.values());
		
		List<Object> actualList = javaProgramsServiceImpl.getFibonacciSeriesFromMap(6);
		
		assertThat(actualList, CoreMatchers.is(expectedList));
	}
}