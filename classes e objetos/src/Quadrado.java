
public class Quadrado {
	
	private double lado;

	public Quadrado() {
		this(0.0);
	}

	public Quadrado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return this.lado;
	}

	public void setLado(double lado) {
		if (lado >= 0.0) {
			this.lado = lado;
		}
	}
	
	public double calculaArea() {
		return this.lado * this.lado;
	}
}
