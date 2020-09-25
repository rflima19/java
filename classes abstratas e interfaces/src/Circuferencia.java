
public class Circuferencia implements AreaCalculavel {
	
	private double raio;
	
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
		return (this.raio * this.raio) * Math.PI;
	}
}
