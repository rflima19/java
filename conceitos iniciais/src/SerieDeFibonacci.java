
public class SerieDeFibonacci {

	public static void main(String[] args) {
		int qtdNumeros = 15;
		int num1 = 0;
		int num2 = 1;
		int aux = 0;
		char separador = ',';
		
		for (int i = 0; i < qtdNumeros; i++) {
			if (i == 0) {
				System.out.print(num1);
			} else if (i == 1) {
				System.out.print(separador + " " + num2);
			} else {
				aux = num1;
				num1 = num2;
				num2 = aux + num2;
				System.out.print(separador + " " + num2);
			}
		}
		
	}
}
