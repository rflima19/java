package com.lima.collections;

import java.util.Arrays;

public class Pilha extends Colecao {

	public Pilha() {
		super();
	}
	
	public Pilha(int tamanho) {
		super(tamanho);
	}

	public Pilha(Object[] array) {
		super(array);
	}

	@Override
	public void inserirItem(Object item) {
		if (this.array.length == 0) {
			throw new ArrayIndexOutOfBoundsException(0);
		}
		if (this.array[0] == null) {
			this.array[0] = item;
		} else {
			int tamanho = 0;
			if (this.array[this.array.length - 1] != null) {
				tamanho = this.array.length + 10;
			} else {
				tamanho = this.array.length;
			}
			Object[] objArray = new Object[tamanho];
			for (int i = 0; i < this.array.length; i++) {
				if (this.array[i] == null) {
					break;
				}
				objArray[i + 1] = this.array[i];
			}
			objArray[0] = item;
			this.array = objArray;
		}
	}

	@Override
	public Object removerItem() {
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
