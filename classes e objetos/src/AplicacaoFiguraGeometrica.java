
public class AplicacaoFiguraGeometrica {

	public static void main(String[] args) {
		
		Triangulo triangulo = new Triangulo(10, 15);
		Quadrado quadrado = new Quadrado(8.5);
		Circuferencia circuferencia = new Circuferencia(34.90);
		Trapezio trapezio = new Trapezio(4, 3, 5);
		
		System.out.println("Calcula �rea");
		System.out.println("Triangulo = " + triangulo.calcularArea());
		System.out.println("Quadrado = " + quadrado.calcularArea());
		System.out.println("Circufer�ncia = " + circuferencia.calcularArea());
		System.out.println("Trap�zio = " + trapezio.calcularArea());
	}
}
