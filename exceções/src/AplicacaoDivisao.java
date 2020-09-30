
public class AplicacaoDivisao {

	public static void main(String[] args) {
		
		int numerador = 0;
		int divisor = 0;
		
		try {
			int resultado = numerador / divisor;
			System.out.println(numerador + "/" + divisor + " = " + resultado);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
