package com.lima.salvalivros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Livro implements Recordable {

	private String titulo;
	private int numPaginas;
	private Autor autor;

	public Livro() {
		super();
		this.autor = new Autor();
	}

	public Livro(String titulo, int numPaginas, Autor autor) {
		super();
		this.titulo = titulo;
		this.numPaginas = numPaginas;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void read(DataInputStream in) throws IOException {
		this.titulo = in.readUTF();
		this.numPaginas = in.readInt();
		this.autor.read(in);
	}

	public void write(DataOutputStream out) throws IOException {
		out.writeUTF(this.titulo);
		out.writeInt(this.numPaginas);
		this.autor.write(out);
	}
}
