
public class Triangulo {

	private double base;
	private double altura;

	public Triangulo() {
		this(0.0, 0.0);
	}

	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		if (base >= 0.0) {
			this.base = base;
		}
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		if (altura >= 0)
			this.altura = altura;
	}
	
	public double calcularArea() {
		return (this.base * this.altura) / 2;
	}

}
