package lima.com;

public class NumeroNegativo extends Exception {

	private static final long serialVersionUID = 1L;

	public NumeroNegativo() {
		super();
	}

	public NumeroNegativo(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NumeroNegativo(String message, Throwable cause) {
		super(message, cause);
	}

	public NumeroNegativo(String message) {
		super(message);
	}

	public NumeroNegativo(Throwable cause) {
		super(cause);
	}

}
