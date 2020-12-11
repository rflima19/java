package com.lima.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysGenerics {

	public static <T> T[] ChangeElementPosition(T[] array, int pos1, int pos2) {
		int length = array.length;
		if ((pos1 < 0) || (pos2 >= length)) {
			throw new ArrayIndexOutOfBoundsException("max limit = " + length + ", pos1 = " + pos1 + ", pos2 = " + pos2);
		}

		
		/*
		 * Usando classe Arrays para fazer a c�pia do array: na implementa��o do m�todo
		 * copyOf() usa-se reflex�o para criar o array g�nerico
		 */
		// T[] arrayAux = Arrays.copyOf(array, length);

		
		
		/*
		 * Criando array gen�rico no Java usando reflex�o
		 */
		// T[] arrayAux = ((Object)array.getClass() == (Object)Object[].class) ? (T[])
		// new Object[length] : (T[])
		// Array.newInstance(array.getClass().getComponentType(), length);
		Class<? extends Object[]> newType = array.getClass();
		T[] arrayAux = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[length]
				: (T[]) Array.newInstance(newType.getComponentType(), length);
		// System.arraycopy(array, 0, arrayAux, 0, length);
		for (int i = 0; i < length; i++) {
			arrayAux[i] = array[i];
		}

		
		T aux = arrayAux[pos1];
		arrayAux[pos1] = arrayAux[pos2];
		arrayAux[pos2] = aux;
		return arrayAux;
	}
}
