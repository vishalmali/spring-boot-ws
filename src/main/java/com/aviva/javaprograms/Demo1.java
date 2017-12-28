package com.aviva.javaprograms;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {
	private static Map<Integer, BigInteger> memo = new HashMap<>();

	String s = "{\"1\":1,\"2\":1,\"3\":2,\"4\":3,\"5\":5,\"6\":8}";
	
	public static void main(String[] args) {

		for (int i = 1; i < 31; i++) {
			memo.put(i, fibonacci3(i));
			 //System.out.println(fibonacci3(i));
		}

		System.out.println(memo);
		//System.out.println(memo.values());
	}

	public static BigInteger fibonacci3(int n) {
		if (n == 0 ) {
			return BigInteger.ZERO;
		}
		if ( n == 1) {
			return BigInteger.ONE;
		}
		/*if (memo.containsKey(n)) {
			return memo.get(n);
		}*/
		BigInteger v = fibonacci3(n - 2).add(fibonacci3(n - 1));
		return v;
	}

	/*public static BigInteger fibonacci2(int n) {
		if (n == 0 || n == 1) {
			return BigInteger.ONE;
		}
		return fibonacci2(n - 2).add(fibonacci2(n - 1));
	}*/

}
