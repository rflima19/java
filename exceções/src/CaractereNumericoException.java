
public class CaractereNumericoException extends Exception {

	private static final long serialVersionUID = 1L;
	private char caractereNumerico;

	public CaractereNumericoException(char caractereNumerico) {
		super();
		this.caractereNumerico = caractereNumerico;
	}
	
	public CaractereNumericoException(char caractereNumerico, String message) {
		super(message);
		this.caractereNumerico = caractereNumerico;
	}

	public CaractereNumericoException(char caractereNumerico, String message, Throwable cause) {
		super(message, cause);
		this.caractereNumerico = caractereNumerico;
	}

	public char getCaractereNumerico() {
		return caractereNumerico;
	}
}
