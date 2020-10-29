package com.lima.salvalivros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Autor implements Recordable {

	private String nome;
	private LocalDate dataNascimento;

	public Autor() {
		super();
	}

	public Autor(String nome, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public void read(DataInputStream in) throws IOException {
		this.nome = in.readUTF();
		int dia = in.readInt();
		int mes = in.readInt();
		int ano = in.readInt();
		this.dataNascimento = LocalDate.of(ano, mes, dia);
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		out.writeUTF(this.nome);
		out.writeInt(this.dataNascimento.getDayOfMonth());
		out.writeInt(this.dataNascimento.getMonthValue());
		out.writeInt(this.dataNascimento.getYear());
	}

}
