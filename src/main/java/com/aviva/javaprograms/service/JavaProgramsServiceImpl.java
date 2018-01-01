package com.aviva.javaprograms.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.aviva.javaprograms.dto.Response;
import com.aviva.javaprograms.exception.InvalidInputException;
import com.aviva.javaprograms.util.JavaProgramsUtils;

/**
 * @author Vishal Mali
 *         <p>
 *         This is a service implementation of {@link JavaProgramsService} which
 *         provides various services related to java programs. Services are
 *         listed below:
 *         <ul>
 *         <li>Fibonacci Series</li>
 *         <li>Fibonacci Series with index</li>
 *         </ul>
 * 
 *         {@link BigInteger} is used across the methods, so that Fibonacci
 *         series of the big numbers can be calculated.
 */
@Service
public class JavaProgramsServiceImpl implements JavaProgramsService {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BigInteger> getFibonacciSeries(String input) {
		validateInput(input);
		return new ArrayList<>(JavaProgramsUtils.generateFibonacciSeries(Integer.parseInt(input)).values());
		// TODO: Uncomment the below statement and comment the above statement to generate Fibonacci Series recursively.
		// return new ArrayList<>(JavaProgramsUtils.generateFibonacciSeriesRecursively(Integer.parseInt(input)).values());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, BigInteger> getFibonacciSeriesWithIndexes(String input) {
		validateInput(input);
		return JavaProgramsUtils.generateFibonacciSeries(Integer.parseInt(input));
		// TODO: Uncomment the below statement and comment the above statement to generate Fibonacci Series recursively.
		// return JavaProgramsUtils.generateFibonacciSeriesRecursively(Integer.parseInt(input));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response getFibonacciSeriesWithPagination(String input, String pageNo, String recordsPerPage) {
		validateInputs(input, pageNo, recordsPerPage);

		int inputInt = Integer.valueOf(input);
		int pageNoInt = Integer.valueOf(pageNo);
		int recordsPerPageInt = Integer.valueOf(recordsPerPage);

		Response response = new Response();
		response.setInput(input);
		response.setPageNo(pageNo);
		response.setRecordsPerPage(recordsPerPage);

		int mod = inputInt % recordsPerPageInt;
		int rawSize = inputInt / recordsPerPageInt;

		int noOfPagesAvailable = mod == 0 ? rawSize : rawSize + 1;

		if (noOfPagesAvailable >= pageNoInt) {
			int toIndex = (pageNoInt * recordsPerPageInt);

			if (toIndex >= inputInt) {
				toIndex = inputInt;
			}

			int fromIndex = ((pageNoInt - 1) * recordsPerPageInt) - 1 < 0 ? 0 : ((pageNoInt - 1) * recordsPerPageInt);

			List<BigInteger> fibonacciSeries = new ArrayList<>(
					JavaProgramsUtils.generateFibonacciSeries(inputInt).values());
			response.setFibonacciSeries(fibonacciSeries.subList(fromIndex, toIndex));

			Map<Integer, BigInteger> fibonacciSeriesWithIndexes = JavaProgramsUtils.generateFibonacciSeries(inputInt);
			response.setFibonacciSeriesWithIndexes(
					new TreeMap<>(fibonacciSeriesWithIndexes).subMap(fromIndex + 1, toIndex + 1));
		} else {
			throw new InvalidInputException("'" + pageNo + "'" + " passed is not a valid number");
		}
		return response;
	}
	
	/**
	 * Validates input string
	 * 
	 * @param input
	 *            String to be validated
	 * @exception throws
	 *                {@link InvalidInputException} if passed input string is not
	 *                numeric or zero
	 */
	private void validateInput(String input) {
		if (!StringUtils.isNumeric(input) || Integer.parseInt(input) == 0) {
			throw new InvalidInputException("'" + input + "'" + " passed is not a valid number");
		}
	}
	
	private void validateInputs(String input, String pageNo, String recordsPerPage) {
		validateInput(input);
		validateInput(pageNo);
		validateInput(recordsPerPage);
	}
}
