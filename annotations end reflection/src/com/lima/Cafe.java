package com.lima;

public class Cafe implements Bebida {

	@Override
	public void preparar() {
		System.out.println("Preparou café");
	}
}
