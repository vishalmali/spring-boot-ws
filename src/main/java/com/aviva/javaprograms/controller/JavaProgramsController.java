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

@RestController
public class JavaProgramsController {
	@Autowired
	JavaProgramsService javaProgramsService;

	@GetMapping("/fibo/{input}")
	public ResponseEntity<List<Object>> getFibonacciSeries(@PathVariable String input)
			throws InvalidInputException {
		return new ResponseEntity<List<Object>>(javaProgramsService.getFibonacciSeries(input), HttpStatus.OK);
	}
}
