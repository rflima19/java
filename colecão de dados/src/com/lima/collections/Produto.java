package com.lima.collections;

import java.text.NumberFormat;
import java.util.Locale;

public class Produto implements Comparable<Produto> {

	private String nome;
	private double valor;

	public Produto(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
	
	@Override
	public int compareTo(Produto o) {
		return Double.valueOf(this.valor).compareTo(o.valor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return String.format("[nome=%s, valor=%s]", this.nome, format.format(this.valor));
	}

}
