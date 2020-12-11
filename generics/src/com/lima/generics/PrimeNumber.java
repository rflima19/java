package com.lima.generics;

public class PrimeNumber implements SearchPropertyNumber {

	@Override
	public <N extends Number> boolean filter(N number) {
		int aux = number.intValue();
		for(int i = 2; i < aux; i++) {
			if (aux % i == 0) {
				return false;
			}
		}
		return true;
	}
}
