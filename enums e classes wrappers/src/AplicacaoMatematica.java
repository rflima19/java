
public class AplicacaoMatematica {

	public static void main(String[] args) {
		int soma = Matematica.somar(12, 45, 8932);
		int decimal = Matematica.converterBinarioParaDecimal("11010011");
		double graus = Matematica.converterAngulo(0.78, Matematica.TipoAngulo.RADIANOS);
		double radianos = Matematica.converterAngulo(45.0, Matematica.TipoAngulo.GRAUS);
		
		System.out.println("Soma = " + soma);
		System.out.println("Decimal = " + decimal);
		System.out.printf("Graus = %.2f %s%n", graus, Matematica.TipoAngulo.GRAUS.getSimbolo());
		System.out.printf("Radianos = %.2f %s%n", radianos, Matematica.TipoAngulo.RADIANOS.getSimbolo());
	}
}
