package com.lima;

import java.util.function.BinaryOperator;

public class Calculadora {

	public static <T extends Number> T calcular(T num1, T num2, Operador<T> op) {
		T result = op.aplicar(num1, num2);
		return result;
	}
	
	public static <T extends Number> T calcularBinaryOperator(T num1, T num2, BinaryOperator<T> binOp) {
		T result = binOp.apply(num1, num2);
		return result;
	}
}
