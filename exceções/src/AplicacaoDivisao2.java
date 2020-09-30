import java.io.IOException;

public class AplicacaoDivisao2 {

	public static void main(String[] args) {
		
		int numerador = 0;
		int divisor = 0;
		int resultado = 0;
		
		try {
			System.out.println("Digite o numerador: ");
			numerador = Console.readInt();
			System.out.println("Digite o divisor: ");
			divisor = Console.readInt();
			
			resultado = numerador / divisor;
			
			System.out.println(numerador + "/" + divisor + " = " + resultado);
		} catch (IOException | NumberFormatException | ArithmeticException  e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
