package com.lima.listacompras;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public interface Registravel {

	public void ler(DataInputStream in) throws IOException;
	public void gravar(RandomAccessFile out) throws IOException;
}
