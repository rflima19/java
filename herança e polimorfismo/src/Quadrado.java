
public class Quadrado extends Figura {
	
	private double lado;

	public Quadrado(double lado) {
		super();
		this.lado = lado;
	}

	public double getLado() {
		return this.lado;
	}
	
	@Override
	public double calcularArea() {
		return this.lado * this.lado;
	}
}
