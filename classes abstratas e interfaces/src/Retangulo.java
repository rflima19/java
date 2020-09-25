
public class Retangulo implements AreaCalculavel {

	private double altura;
	private double largura;

	public Retangulo(double altura, double largura) {
		super();
		this.altura = altura;
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}

	@Override
	public double calcularArea() {
		return this.largura * this.altura;
	}
}
