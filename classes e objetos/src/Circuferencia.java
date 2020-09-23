
public class Circuferencia {

	public static final double PI = 3.14;
	private double raio;

	public Circuferencia() {
		this(0.0);
	}
	
	public Circuferencia(double raio) {
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public double calcularArea() {
		return (this.raio * this.raio) * Circuferencia.PI;
	}
}
