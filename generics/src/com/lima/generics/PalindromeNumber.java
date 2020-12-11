package com.lima.generics;

public class PalindromeNumber implements SearchPropertyNumber {

	@Override
	public <N extends Number> boolean filter(N number) {
		String str = number.toString();
		StringBuilder strBuilder = new StringBuilder(str);
		return strBuilder.reverse().toString().equals(str);
	}
}
