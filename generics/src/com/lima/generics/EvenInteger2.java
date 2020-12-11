package com.lima.generics;

public class EvenInteger2 extends SearchPropertyNumber2<Integer> {

	@Override
	public boolean filter(Integer number) {
		return (number.intValue() % 2) == 0 ? true : false;
	}
}
