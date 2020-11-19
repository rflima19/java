package com.lima.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

	public static final Pattern PATTERN_CPF = Pattern.compile("\\d{3}([\\.\\s])?\\d{3}([\\.\\s])?\\d{3}([-\\s])?\\d{2}");
	public static final Pattern PATTERM_CEP = Pattern.compile("\\d{5}([-\\s])?\\d{3}");
	public static final Pattern PATTERN_TELEFONE = Pattern.compile("(\\(\\d{2}\\)\\s)?\\d{4}([\\s-])?\\d{4}");
	
	public static boolean validarCPF(String cpf) {
		Matcher matcher = Validador.PATTERN_CPF.matcher(cpf);
		return matcher.matches();
	}
	
	public static boolean validarCEP(String cep) {
		Matcher matcher = Validador.PATTERM_CEP.matcher(cep);
		return matcher.matches();
	}
	
	public static boolean validarTelefone(String telefone) {
		Matcher matcher = Validador.PATTERN_TELEFONE.matcher(telefone);
		return matcher.matches();
	}
}
