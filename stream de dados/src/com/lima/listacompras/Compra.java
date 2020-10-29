package com.lima.listacompras;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class Compra implements Registravel {

	private Set<Item> itens;
	private LocalDateTime data;
	private double valor;
	
	public Compra() {
		super();
		this.itens = new TreeSet<>(new OrdenacaoAlfabetica());
	}

	public Compra(Set<Item> itens, LocalDateTime data) {
		super();
		this.itens = itens;
		this.data = data;
		this.valor = this.calcularValorCompra();
	}
	
	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double calcularValorCompra() {
		if (this.itens.size() == 0) {
			return 0.0;
		}
		double valor = 0.0;
		for (Item i : this.itens) {
			valor += (i.getPreco() * i.getQuantidade());
		}
		return valor;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fd = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		NumberFormat fn = NumberFormat.getCurrencyInstance(Locale.getDefault());
		String texto = String.format("%s %s:%n",fd.format(this.data), fn.format(this.valor));
		StringBuilder strb = new StringBuilder(texto);
		for (Item i : this.itens) {
			strb.append(i.toString() + "\n");
		}
		return strb.toString();
	}

	@Override
	public void ler(DataInputStream in) throws IOException {
		int quantidadeItensCompra = in.readInt();
		int mes = in.readInt();
		int dia = in.readInt();
		int ano = in.readInt();
		int hora = in.readInt();
		int minutos = in.readInt();
		int segundos = in.readInt();
		this.data = LocalDateTime.of(ano, mes, dia, hora, minutos, segundos);
		this.valor = in.readDouble();
		
		Item item = null;
		for (int i = 0; i < quantidadeItensCompra; i++) {
			item = new Item();
			item.ler(in);
			this.itens.add(item);
		}
	}

	@Override
	public void gravar(RandomAccessFile out) throws IOException {
		out.writeInt(this.itens.size());	// Quantidade de itens comprados
		out.writeInt(this.data.getMonthValue());
		out.writeInt(this.data.getDayOfMonth());
		out.writeInt(this.data.getYear());
		out.writeInt(this.data.getHour());
		out.writeInt(this.data.getMinute());
		out.writeInt(this.data.getSecond());
		out.writeDouble(this.valor);
		
		for (Item item : this.itens) {
			item.gravar(out);
		}
	}
}
