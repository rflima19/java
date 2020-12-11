package com.lima.generics;

public class EvenInteger implements SearchPropertyNumber {

	@Override
	public <N extends Number> boolean filter(N number) {
		return (number.intValue() % 2) == 0 ? true : false;
	}
}
