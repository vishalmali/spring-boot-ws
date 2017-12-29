package com.aviva.javaprograms.dto;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class Response {
	private String input;
	private String pageNo;
	private String recordsPerPage;
	List<BigInteger> fibonacciSeries;
	Map<Integer, BigInteger> fibonacciSeriesWithIndexes;

	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getRecordsPerPage() {
		return recordsPerPage;
	}
	public void setRecordsPerPage(String recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	public List<BigInteger> getFibonacciSeries() {
		return fibonacciSeries;
	}
	public void setFibonacciSeries(List<BigInteger> fibonacciSeries) {
		this.fibonacciSeries = fibonacciSeries;
	}
	public Map<Integer, BigInteger> getFibonacciSeriesWithIndexes() {
		return fibonacciSeriesWithIndexes;
	}
	public void setFibonacciSeriesWithIndexes(Map<Integer, BigInteger> fibonacciSeriesWithIndexes) {
		this.fibonacciSeriesWithIndexes = fibonacciSeriesWithIndexes;
	}
}
