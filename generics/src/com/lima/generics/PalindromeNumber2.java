package com.lima.generics;

public class PalindromeNumber2 extends SearchPropertyNumber2<Number> {

	@Override
	public boolean filter(Number number) {
		String str = number.toString();
		StringBuilder strBuilder = new StringBuilder(str);
		return strBuilder.reverse().toString().equals(str);
	}
}
