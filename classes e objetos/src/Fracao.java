
public class Fracao {

	private double denominador;
	private double numerador;

	public Fracao() {
		this(0.0, 1.0);
	}

	public Fracao(double numerador, double denominador) {
//		this.numerador = numerador;
//		this.denominador = denominador;
		this.setNumerador(numerador);
		this.setDenominador(denominador);
	}

	public double getNumerador() {
		return this.numerador;
	}

	public void setNumerador(double valor) {
		this.numerador = valor;
	}

	public double getDenominador() {
		return this.denominador;
	}

	public void setDenominador(double valor) throws ArithmeticException {
		if (valor == 0) {
			throw new ArithmeticException("Não é possivel divisão por zero.");
		}
		this.denominador = valor;
	}

	public Fracao multiplicarPorFracao(double numerador, double denominador) throws ArithmeticException {
		if (denominador == 0) {
			throw new ArithmeticException("Não é possível divisão por zero.");
		}
		double n = this.numerador * numerador;
		double d = this.denominador * denominador;
		Fracao f = new Fracao(n, d);
		return f;
	}

	public Fracao multiplicarPorFracao(Fracao fracao) throws ArithmeticException {
//		double n = this.numerador * fracao.getNumerador();
//		double d = this.denominador * fracao.getDenominador();
//		Fracao f = new Fracao(n, d);
//		return f;

		return this.multiplicarPorFracao(fracao.getNumerador(), fracao.getDenominador());
	}
	
	public double calcularFracao() {
		return this.numerador / this.denominador;
	}

	@Override
	public String toString() {
		return this.numerador + "/" + this.denominador;
	}
	
	private int calcularMMC(int num1, int num2) {
		int aux = 2;
		int resultado = 1;
		
		while (num1 != 1 || num2 != 1) {
			while ((num1 % aux != 0) && (num2 % aux != 0)) {
				aux++;
			}
			if (num1 % aux == 0) {
				num1 = num1 / aux;
			}
			if (num2 % aux == 0) {
				num2 /= aux;
			}
			resultado *= aux;
		}
		return resultado;
	}

}
