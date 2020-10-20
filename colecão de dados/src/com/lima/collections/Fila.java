package com.lima.collections;

import java.util.Arrays;

public class Fila extends Colecao {

	public Fila() {
		super();
	}
	
	public Fila(int tamanho) {
		super(tamanho);
	}

	public Fila(Object[] array) {
		super(array);
	}

	@Override
	public void inserirItem(Object item) {
		if (this.array.length == 0) {
			throw new ArrayIndexOutOfBoundsException(0);
		}
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == null) {
				this.array[i] = item;
				return;
			}
		}
		Object[] objArray = new Object[this.array.length + 10];
		//System.arraycopy(this.array, 0, objArray, 0, this.array.length);
		for (int i = 0; i < this.array.length; i++) {
			objArray[i] = this.array[i];
		}
		objArray[this.array.length] = item;
		this.array = objArray;
	}

	@Override
	public Object removerItem() {
//		if (this.array.length == 0) {
//			throw new ArrayIndexOutOfBoundsException(0);
//		}
//		Object obj = this.array[0];
//		Object[] objArray = new Object[this.array.length - 1];
//		System.arraycopy(this.array, 1, objArray, 0, this.array.length - 1);
//		this.array = objArray;
//		return obj;
		
		if (this.array.length == 0) {
			throw new ArrayIndexOutOfBoundsException(0);
		}
		if (this.array[0] == null) {
			return null;
		}
		Object objAux = null;
		if (this.array.length == 1) {
			objAux = this.array[0];
			this.array[0] = null;
		} else {
			objAux = this.array[0];
			Object[] objArray = new Object[this.array.length];
			for (int i = (this.array.length - 1); i > 0; i--) {
				if (this.array[i] == null) {
					continue;
				}
				objArray[i - 1] = this.array[i];
			}
			this.array = objArray;
		}
		return objAux;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.array);
	}
}
