
public class FiguraComplexa extends Figura {

	private Figura[] figuras;

	public FiguraComplexa(Figura... figuras) {
		super();
		this.figuras = figuras;
	}
	
	public Figura[] getFiguras() {
		return this.figuras;
	}
	
	@Override
	public double calcularArea() {
		double areaTotal = 0.0;
		for (Figura f : this.figuras) {
			areaTotal += f.calcularArea();
		}
		return areaTotal;
	}
}
