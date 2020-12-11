package com.lima.generics;

public class Codigo<T, U> {

	private T parte1;
	private U parte2;
	
	public Codigo(T parte1, U parte2) {
		super();
		this.parte1 = parte1;
		this.parte2 = parte2;
	}
	
	public T getParte1() {
		return parte1;
	}
	
	public U getParte2() {
		return parte2;
	}
	
	@Override
	public String toString() {
		return String.format("%s%s", this.parte1, this.parte2);
	}
}
