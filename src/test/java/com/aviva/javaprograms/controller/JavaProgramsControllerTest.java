package com.aviva.javaprograms.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.aviva.javaprograms.service.JavaProgramsService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = JavaProgramsController.class, secure = false)
public class JavaProgramsControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	JavaProgramsService javaProgramsService;

	@Test
	public void testGetFibonacciSeries() throws Exception {
		List<BigInteger> fibonacciList = new ArrayList<>();
		fibonacciList.add(BigInteger.valueOf(1));	
		fibonacciList.add(BigInteger.valueOf(1));
		fibonacciList.add(BigInteger.valueOf(2));
		fibonacciList.add(BigInteger.valueOf(3));
		fibonacciList.add(BigInteger.valueOf(5));
		fibonacciList.add(BigInteger.valueOf(8));
		
		String expectedListStr = "[1, 1, 2, 3, 5, 8]";
		
		Mockito.when(javaProgramsService.getFibonacciSeries("6")).thenReturn(fibonacciList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/fibo/6").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		JSONAssert.assertEquals(expectedListStr, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testGetFibonacciSeriesWithIndexes() throws Exception {
		Map<Integer, BigInteger> expectedMap = new HashMap<>();
		expectedMap.put(1, BigInteger.valueOf(1));
		expectedMap.put(2, BigInteger.valueOf(1));
		expectedMap.put(3, BigInteger.valueOf(2));
		expectedMap.put(4, BigInteger.valueOf(3));
		expectedMap.put(5, BigInteger.valueOf(5));
		expectedMap.put(6, BigInteger.valueOf(8));
		
		String expectedMapStr = "{\"1\":1,\"2\":1,\"3\":2,\"4\":3,\"5\":5,\"6\":8}";
		
		Mockito.when(javaProgramsService.getFibonacciSeriesWithIndexes("6")).thenReturn(expectedMap);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/fibo/6").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		JSONAssert.assertEquals(expectedMapStr, result.getResponse().getContentAsString(), false);
	}

}
