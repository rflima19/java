package com.lima;

@FunctionalInterface
public interface Operador<T extends Number> {

	public abstract T aplicar(T num1, T num2);
}
