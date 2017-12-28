package com.aviva.javaprograms.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aviva.javaprograms.service.JavaProgramsService;

/**
 * @author Vishal Mali
 *         <p>
 *         Controller for all the java programs
 *         <p>
 *         Here java programs are exposed as restful web services. Services are
 *         listed below:
 *         <ul>
 *         <li>Fibonacci series</li>
 *         <li>Fibonacci Series with index positions</li></ul>
 */
@RestController
public class JavaProgramsController {
	@Autowired
	JavaProgramsService javaProgramsService;

	/**
	 * Gets Fibonacci Series up to the given number
	 * 
	 * @param input
	 *            A number in String format up to which Fibonacci Series is to be
	 *            generated
	 * @return Fibonacci Series in list format composed in {@link ResponseEntity}
	 */
	@GetMapping("/fibo/{input}")
	public ResponseEntity<List<Object>> getFibonacciSeries(@PathVariable String input) {
		return new ResponseEntity<List<Object>>(javaProgramsService.getFibonacciSeries(input), HttpStatus.OK);
	}
	
	/**
	 * Gets Fibonacci Series up to the given number with their indexes
	 * <p>
	 * Here Fibonacci series is stored as map values and their indexes as keys.
	 *  
	 * @param input
	 *            A number in String format up to which Fibonacci Series is to be
	 *            generated
	 * @return Fibonacci Series in map format composed in {@link ResponseEntity}
	 */
	@GetMapping("/fibowithindexes/{input}")
	public ResponseEntity<Map<Integer, BigInteger> > getFibonacciSeriesWithIndexes(@PathVariable String input) {
		return new ResponseEntity<Map<Integer, BigInteger> >(javaProgramsService.getFibonacciSeriesWithIndexes(input), HttpStatus.OK);
	}
	

}
