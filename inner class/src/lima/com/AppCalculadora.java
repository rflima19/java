package lima.com;

public class AppCalculadora {

	public static void main(String[] args) {
		Calculadora calc = new Calculadora(200, 100);
		System.out.println(calc.somar());
		System.out.println(calc.subtrair());
		System.out.println(calc.multiplicar());
		System.out.println(calc.dividir());
	}
}
