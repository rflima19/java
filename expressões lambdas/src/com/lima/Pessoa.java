package com.lima;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pessoa {

	public enum Sexo {
		MASCULINMO, FEMININO;
	}

	private String nome;
	private LocalDate dataNascimetno;
	private Sexo genero;
	private String email;

	public Pessoa(String nome, LocalDate dataNascimetno, Sexo genero, String email) {
		super();
		this.nome = nome;
		this.dataNascimetno = dataNascimetno;
		this.genero = genero;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimetno() {
		return dataNascimetno;
	}

	public Sexo getGenero() {
		return genero;
	}

	public String getEmail() {
		return email;
	}

	public int getIdade() {
		return (int) ChronoUnit.YEARS.between(this.dataNascimetno.plusDays(1), LocalDate.now());
	}
	
	public void setIdade(int newIdade) {
		this.dataNascimetno = LocalDate.of(
				LocalDate.now().getYear() - ++newIdade, 
				this.dataNascimetno.getMonthValue(), 
				this.dataNascimetno.getDayOfMonth());
	}

	public void imprimir() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.printf("[nome=%s, datNasc=%s, idade=%d, genero=%s, email=%s]%n", this.nome, dtf.format(this.dataNascimetno), this.getIdade(),
				this.genero.toString().toLowerCase(), this.email);
	}
	
	public double calcularFator() {
		double ajuste = 0.2;
		FactorCalculator c = () -> this.getIdade() * 10 / 2 * ajuste;
		// ajuste = 0.5; // erro
		return c.calculate();
	}
}
