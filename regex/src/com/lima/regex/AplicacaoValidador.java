package com.lima.regex;

public class AplicacaoValidador {

	public static void main(String[] args) {
		String cpf1 = "432.567.324-01";
		String cpf2 = "43256732401";
		String cpf3 = "432 567 324 01";
		String cpf4 = "432%567%324*01";
		String cpf5 = "4324 5647 32401";
		
		String cep1 = "33370-340";
		String cep2 = "33370 340";
		String cep3 = "370-340";
		String cep4 = "0000370-34";
		
		String telefone1 = "5634-2395";
		String telefone2 = "5634 2395";
		String telefone3 = "(99) 5634-2395";
		String telefone4 = "(99)5634-2395";
		String telefone5 = "(9) 5634-2395";
		String telefone6 = "563 23695";
		
		System.out.println("CPF:");
		System.out.println(cpf1 + " = " + Validador.validarCPF(cpf1));
		System.out.println(cpf2 + " = " + Validador.validarCPF(cpf2));
		System.out.println(cpf3 + " = " + Validador.validarCPF(cpf3));
		System.out.println(cpf4 + " = " + Validador.validarCPF(cpf4));
		System.out.println(cpf5 + " = " + Validador.validarCPF(cpf5));
		
		System.out.println("CEP:");
		System.out.println(cep1 + " = " + Validador.validarCEP(cep1));
		System.out.println(cep2 + " = " + Validador.validarCEP(cep2));
		System.out.println(cep3 + " = " + Validador.validarCEP(cep3));
		System.out.println(cep4 + " = " + Validador.validarCEP(cep4));
		
		System.out.println("Telefone:");
		System.out.println(telefone1 + " = " + Validador.validarTelefone(telefone1));
		System.out.println(telefone2 + " = " + Validador.validarTelefone(telefone2));
		System.out.println(telefone3 + " = " + Validador.validarTelefone(telefone3));
		System.out.println(telefone4 + " = " + Validador.validarTelefone(telefone4));
		System.out.println(telefone5 + " = " + Validador.validarTelefone(telefone5));
		System.out.println(telefone6 + " = " + Validador.validarTelefone(telefone6));
		
	}
}
