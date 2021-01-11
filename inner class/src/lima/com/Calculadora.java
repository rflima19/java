package lima.com;

public class Calculadora {

	private double valor1;
	private double valor2;
	private double resultado;

	public Calculadora(double valor1, double valor2) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	public double getValor1() {
		return valor1;
	}

	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	public double getValor2() {
		return valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}
	
	public double getResultado() {
		return resultado;
	}
	
	public double somar() {
//		Calculadora.OperacaoMatematica soma = new Soma();
//		return soma.calcular();
		this.executar(new Soma());
		return this.resultado;
	}
	
	public double subtrair() {
//		Calculadora.OperacaoMatematica soma = new Subtracao();
//		return soma.calcular();
		this.executar(new Subtracao());
		return this.resultado;
	}
	
	public double multiplicar() {
//		Calculadora.OperacaoMatematica soma = new Multiplicacao();
//		return soma.calcular();
		this.executar(new Multiplicacao());
		return this.resultado;
	}
	
	public double dividir() {
		this.executar(new Divisao());
		return this.resultado;
	}
	
	private void executar(Calculadora.OperacaoMatematica operacao) {
		this.resultado = operacao.calcular();
	}

	private abstract class OperacaoMatematica {
		protected double resultado;

		@SuppressWarnings("unused")
		public double getResultado() {
			return resultado;
		}

		public abstract double calcular();
	}

	private class Soma extends OperacaoMatematica {
		@Override
		public double calcular() {
			this.resultado = Calculadora.this.valor1 + Calculadora.this.valor2;
			return this.resultado;
		}
	}

	private class Subtracao extends OperacaoMatematica {
		@Override
		public double calcular() {
			this.resultado = Calculadora.this.valor1 - Calculadora.this.valor2;
			return this.resultado;
		}
	}

	private class Multiplicacao extends OperacaoMatematica {
		@Override
		public double calcular() {
			this.resultado = Calculadora.this.valor1 * Calculadora.this.valor2;
			return this.resultado;
		}
	}

	private class Divisao extends OperacaoMatematica {
		@Override
		public double calcular() {
			this.resultado = Calculadora.this.valor1 / Calculadora.this.valor2;
			return this.resultado;
		}
	}
}
