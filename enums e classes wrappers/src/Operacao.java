
public enum Operacao {

	SOMA('+'), SUBTRACAO('-'), MULTIPLICACAO('X'), DIVISAO('/');
	
	private char simbolo;

	private Operacao(char simbolo) {
		this.simbolo = simbolo;
	}
	
	public char getSimbolo() {
		return this.simbolo;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getSimbolo());
	}
	
	public double calcular(double n1, double n2) {
		double resultado = 0.0;
		switch(this) {
		case SOMA -> {
			resultado = n1 + n2;
		} case SUBTRACAO -> {
			resultado = n1 - n2;
		} case MULTIPLICACAO -> {
			resultado = n1 * n2;
		} case DIVISAO -> {
			try {
				resultado = n1 / n2;
			} catch (ArithmeticException e) {
				throw new IllegalArgumentException("Parâmetro inválido: double n2 == 0", e);
			}
		} default -> {
			throw new UnsupportedOperationException("O cálculo não pode ser realizado");
		}
		}
		return resultado;
	}
}
