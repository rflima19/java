package com.lima.regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Foto {

	private int id;
	private LocalDate data;
	private String local;

	public Foto(int id, LocalDate data, String local) {
		super();
		this.id = id;
		this.data = data;
		this.local = local;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault());
		return String.format("[id=%d, data=%s, local=%s]%n", this.id, format.format(this.data), this.local);
	}
}
