package com.rafael.jogodavelha.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	public static String readString() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();

	}

	public static int readInt() throws IOException, NumberFormatException {
		String str = readString();
		return Integer.parseInt(str);
	}

	public static double readDouble() throws IOException, NumberFormatException {
		String str = readString();
		return Double.parseDouble(str);
	}
}
