/*
 * Verifique a validade de uma data e mostre uma mensagem na tela dizendo se a data � v�lida ou
 * inv�lida. Deve haver tr�s vari�veis para armazenar esta data: uma para o dia, outra para o m�s
 * e outra para o ano. Considere que fevereiro pode ter somente 28 dias. 

 * */
public class ValidaData {

	public static void main(String[] args) {
		byte dia = 2;
		byte mes = 1;
		short ano = 2020;
		String resultado = "Data v�lida";

		if (ano >= 1500 && ano <= 2050) {
			switch (mes) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				if (dia < 1 || dia > 31) {
					resultado = "Data inv�lida";
				}
			}
			case 4, 6, 9, 11 -> {
				if (dia < 1 || dia > 30) {
					resultado = "Data inv�lida";
				}
			}
			case 2 -> {
				if (dia < 1 || dia > 28) {
					resultado = "Data inv�lida";
				}
			}
			default -> {
				resultado = "Data inv�lida";
			}
			}
		} else {
			resultado = "Data inv�lida";
		}

		System.out.println(dia + "/" + mes + "/" + ano + " = " + resultado);
	}
}
