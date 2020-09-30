public class ValorInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private double valor;
	
	public ValorInvalidoException(String message, double valor) {
		super(message);
		this.valor = valor;
	}

	public ValorInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValorInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValorInvalidoException(String message) {
		super(message);
	}

	public ValorInvalidoException(Throwable cause) {
		super(cause);
	}
	
	public double getValor() {
		return this.valor;
	}

}
