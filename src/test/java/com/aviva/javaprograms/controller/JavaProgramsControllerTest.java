package com.aviva.javaprograms.controller;

import java.util.Arrays;

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

	Object[] array = new Object[] { 1, 1, 2, 3, 5, 8 };
	String expected = "[1, 1, 2, 3, 5, 8]";

	@Test
	public void testGetFibonacciSeries() throws Exception {
		Mockito
		.when(javaProgramsService.getFibonacciSeries("6"))
		.thenReturn(Arrays.asList(array));

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/fibo/6")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}
}
