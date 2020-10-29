package com.lima.listacompras;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.Locale;

import com.lima.listacompras.exceptions.NomeInvalidoException;
import com.lima.listacompras.exceptions.PesoInvalidoException;
import com.lima.listacompras.exceptions.PrecoInvalidoException;
import com.lima.listacompras.exceptions.QuantidadeInvalidaException;

public class Item implements Registravel {

	private String nome;
	private double preco;
	private double peso;
	private int quantidade;
	
	public Item() {
		super();
	}
	
	public Item(String nome, double preco, double peso, int quantidade) 
			throws PesoInvalidoException, PrecoInvalidoException, QuantidadeInvalidaException, 
			NomeInvalidoException {
		super();
		this.setNome(nome);
		this.setPeso(peso);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		if (nome.isBlank()) {
			throw new NomeInvalidoException(nome, "Não é permitido nome em branco.");
		}
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) throws PrecoInvalidoException {
		if (preco <= 0.0) {
			throw new PrecoInvalidoException(preco, "Não é permitido preco 0.0 ou negativo.");
		}
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) throws PesoInvalidoException {
		if (peso <= 0.0) {
			throw new PesoInvalidoException(peso, "Não é permitido peso 0.0 ou negativo.");
		}
		this.peso = peso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) throws QuantidadeInvalidaException {
		if (quantidade <= 0) {
			throw new QuantidadeInvalidaException(quantidade, "Não é permitida quantidade 0 ou negativa.");
		}
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return String.format("[%s, %s, %.2f KG, %d]", this.nome, format.format(this.preco), 
				this.peso, this.quantidade);
	}

	@Override
	public void ler(DataInputStream in) throws IOException {
		int tamanhoMaxCampoNome = 20;
		char[] arrayChar = new char[tamanhoMaxCampoNome];
		for (int i = 0; i < tamanhoMaxCampoNome; i++) {
			char c = in.readChar();
			arrayChar[i] = c;
		}
		this.nome = new String(arrayChar).trim();
		this.preco = in.readDouble();
		this.peso = in.readDouble();
		this.quantidade = in.readInt();
	}

	@Override
	public void gravar(RandomAccessFile out) throws IOException {
		StringBuilder strb = null;
		int tamanhoMaxCampoNome = 20;
		
		strb = new StringBuilder(this.nome);
		strb.setLength(tamanhoMaxCampoNome);
		out.writeChars(strb.toString());
		out.writeDouble(this.preco);
		out.writeDouble(this.peso);
		out.writeInt(this.quantidade);
		
	}
}
