package com.aviva.javaprograms.service;

import java.util.List;

import com.aviva.javaprograms.exception.InvalidInputException;
/**
 * 
 * @author vimali
 *
 */
public interface JavaProgramsService {
	List<Object> getFibonacciSeries(String input)throws InvalidInputException;
}
