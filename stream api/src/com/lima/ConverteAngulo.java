package com.lima;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConverteAngulo {

	public static void main(String[] args) {
		List<Integer> angulosGraus = Arrays.asList(90, 30, 60 , 45, 180);
		
		List<Double> angulosRadianos = angulosGraus.stream()
				.map((Integer i) -> {
					return ConverteAngulo.converterParaRadianos(i);
				})
				.collect(Collectors.toList());
		
		System.out.println(angulosRadianos);
	}
	
	public static double converterParaRadianos(double graus) {
		return Math.toRadians(graus);
	}
	
	public static double converterParaGraus(double radianos) {
		return Math.toDegrees(radianos);
	}
}
