package com.aviva.javaprograms.controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
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

	Object[] array;
	String expectedListStr;
	String expectedMapStr;
	Map<Integer, BigInteger> expectedMap;
	
	@Before
	public void setUp() {
		array = new Object[] { 1, 1, 2, 3, 5, 8 };
		expectedListStr = "[1, 1, 2, 3, 5, 8]";
		
		expectedMap = new HashMap<>();
		expectedMap.put(1, BigInteger.valueOf(1));
		expectedMap.put(2, BigInteger.valueOf(1));
		expectedMap.put(3, BigInteger.valueOf(2));
		expectedMap.put(4, BigInteger.valueOf(3));
		expectedMap.put(5, BigInteger.valueOf(5));
		expectedMap.put(6, BigInteger.valueOf(8));
		expectedMapStr = "{\"1\":1,\"2\":1,\"3\":2,\"4\":3,\"5\":5,\"6\":8}";
	}


	@Test
	public void testGetFibonacciSeries() throws Exception {
		Mockito
		.when(javaProgramsService.getFibonacciSeries("6"))
		.thenReturn(Arrays.asList(array));

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v1/fibo/6")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		JSONAssert.assertEquals(expectedListStr, result.getResponse().getContentAsString(), false);

	}
	
	
	@Test
	public void testGetFibonacciSeriesWithIndexes() throws Exception {
		Mockito
		.when(javaProgramsService.getFibonacciSeriesWithIndexes("6"))
		.thenReturn(expectedMap);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v2/fibo/6")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		JSONAssert.assertEquals(expectedMapStr, result.getResponse().getContentAsString(), false);

	}
	
}
