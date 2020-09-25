
public class AplicacaoCalcularArea {

	public static void main(String[] args) {
		AreaCalculavel q = new Quadrado(14.0);
		AreaCalculavel r = new Retangulo(4.0, 0.5);
		AreaCalculavel c = new Circuferencia(8.0);
		
		System.out.println(q.calcularArea());
		System.out.println(r.calcularArea());
		System.out.println(c.calcularArea());
	}
}
