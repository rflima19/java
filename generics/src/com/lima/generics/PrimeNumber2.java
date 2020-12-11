package com.lima.generics;

public class PrimeNumber2 extends SearchPropertyNumber2<Integer> {

	@Override
	public boolean filter(Integer number) {
		int aux = number.intValue();
		for(int i = 2; i < aux; i++) {
			if (aux % i == 0) {
				return false;
			}
		}
		return true;
	}
}
