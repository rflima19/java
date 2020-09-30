
public class QuantidadeCaracteresInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantidadeCaracteresInsuficienteException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuantidadeCaracteresInsuficienteException(String message) {
		super(message);
	}

	public QuantidadeCaracteresInsuficienteException(Throwable cause) {
		super(cause);
	}

	public QuantidadeCaracteresInsuficienteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
