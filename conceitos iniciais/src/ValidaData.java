/*
 * Verifique a validade de uma data e mostre uma mensagem na tela dizendo se a data é válida ou
 * inválida. Deve haver três variáveis para armazenar esta data: uma para o dia, outra para o mês
 * e outra para o ano. Considere que fevereiro pode ter somente 28 dias. 

 * */
public class ValidaData {

	public static void main(String[] args) {
		byte dia = 2;
		byte mes = 1;
		short ano = 2020;
		String resultado = "Data válida";

		if (ano >= 1500 && ano <= 2050) {
			switch (mes) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				if (dia < 1 || dia > 31) {
					resultado = "Data inválida";
				}
			}
			case 4, 6, 9, 11 -> {
				if (dia < 1 || dia > 30) {
					resultado = "Data inválida";
				}
			}
			case 2 -> {
				if (dia < 1 || dia > 28) {
					resultado = "Data inválida";
				}
			}
			default -> {
				resultado = "Data inválida";
			}
			}
		} else {
			resultado = "Data inválida";
		}

		System.out.println(dia + "/" + mes + "/" + ano + " = " + resultado);
	}
}
