
public class AplicacaoFracao {

	public static void main(String[] args) {
		
		Fracao f1 = new Fracao(12, 6);
		Fracao f2 = new Fracao(9, 2);
		
		Fracao f3 = f1.multiplicarPorFracao(f2);
		
		System.out.println(f1 + " X " + f2 + " = " + f3);
		
		// f3.multiplicarPorFracao(3.0, 0.0);
		
		System.out.println("Calcular fração = " + f3.calcularFracao());
	}
}
