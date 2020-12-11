package com.lima.generics;

import java.text.NumberFormat;
import java.util.Locale;

public class Produto<T> {

	private T codigo;
	private String descricao;
	private double valor;

	public Produto(T codigo, String descricao, double valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}

	public T getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	};

	@Override
	public String toString() {
		return String.format("[codigo=%s / descrisão=%s / valor=%s]", this.codigo, this.descricao,
				NumberFormat.getCurrencyInstance(Locale.getDefault()).format(this.valor));
	}
}
