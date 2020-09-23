
public class Calculador {

	public static void main(String[] args) {
		Figura q1 = new Quadrado(3);
		Figura q2 = new Quadrado(10);
		Figura r1 = new Retangulo(2, 7);
		Figura r2 = new Retangulo(5, 3);
		
		Figura fc = new FiguraComplexa(q1, q2, r1, r2);
		
		System.out.println("Área total: " + fc.calcularArea());
	}
}
