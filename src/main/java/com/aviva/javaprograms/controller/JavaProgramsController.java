package com.aviva.javaprograms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aviva.javaprograms.exception.InvalidInputException;
import com.aviva.javaprograms.service.JavaProgramsService;

/**
 * @author Vishal Mali
 *         <p>
 *         Controller for all the java programs
 *         <p>
 *         Here java programs are exposed as restful web services. Services are
 *         listed below:
 *         <ul>
 *         <li>Fibonacci series</li> </ul
 */
@RestController
public class JavaProgramsController {
	@Autowired
	JavaProgramsService javaProgramsService;

	/**
	 * Gets Fibonacci Series upto the given number
	 * 
	 * @param input
	 *            A number in String format upto which Fibonacci Series is to be
	 *            generated
	 * @return Fibonacci Series in list format composed in {@link ResponseEntity}}
	 * @throws InvalidInputException
	 *             If input provided is invalid
	 */
	@GetMapping("/fibo/{input}")
	public ResponseEntity<List<Object>> getFibonacciSeries(@PathVariable String input) throws InvalidInputException {
		return new ResponseEntity<List<Object>>(javaProgramsService.getFibonacciSeries(input), HttpStatus.OK);
	}
}
