package com.lima.generics;

import java.util.Arrays;

public class AppArraysGenerics {

	public static void main(String[] args) {
		
		Integer[] arrayInteger = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		String[] arrayString = new String[] {"ABC", "DEF", "GHI"};
		
		Integer[] arrayIntegerAux = ArraysGenerics.<Integer>ChangeElementPosition(arrayInteger, 2, 6);
		
		String[] arrayStringAux = ArraysGenerics.<String>ChangeElementPosition(arrayString, 0, 2);
		
		System.out.println(Arrays.toString(arrayIntegerAux));
		System.out.println(Arrays.toString(arrayStringAux));
	}
}
