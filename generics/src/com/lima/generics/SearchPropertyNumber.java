package com.lima.generics;

public interface SearchPropertyNumber {

	public abstract <N extends Number> boolean filter(N number);
}
