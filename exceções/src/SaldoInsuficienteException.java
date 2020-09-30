public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private double saldo;
	
	public SaldoInsuficienteException(String message, double valor) {
		super(message);
		this.saldo = valor;
	}

	public SaldoInsuficienteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SaldoInsuficienteException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaldoInsuficienteException(String message) {
		super(message);
	}

	public SaldoInsuficienteException(Throwable cause) {
		super(cause);
	}
	
	public double getSaldo() {
		return this.saldo;
	}

}
