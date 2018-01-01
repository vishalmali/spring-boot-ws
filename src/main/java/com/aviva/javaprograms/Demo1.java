package com.aviva.javaprograms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import com.aviva.javaprograms.util.JavaProgramsUtils;

public class Demo1 {

	public static void main(String[] args) {
		TreeMap<Integer, BigInteger> treeMap = new TreeMap<>(JavaProgramsUtils.generateFibonacciSeries(20));
		System.out.println(treeMap);
		System.out.println(treeMap.size());
		System.out.println(treeMap.subMap(1, 5));
		
		Collection<BigInteger> collection =  JavaProgramsUtils.generateFibonacciSeries(20).values();
		ArrayList list = new ArrayList<>(collection);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.subList(0, 5 - 1));
	

	}

}
