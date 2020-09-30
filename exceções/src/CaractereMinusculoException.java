
public class CaractereMinusculoException extends Exception {

	private static final long serialVersionUID = 1L;
	private char caractereMinusculo;

	public CaractereMinusculoException(char caractereMinusculo) {
		super();
		this.caractereMinusculo = caractereMinusculo;
	}

	public CaractereMinusculoException(char caractereMinusculo, String message) {
		super(message);
		this.caractereMinusculo = caractereMinusculo;
	}

	public CaractereMinusculoException(char caractereMinusculo, String message, Throwable cause) {
		super(message, cause);
		this.caractereMinusculo = caractereMinusculo;
	}

	public char getCaractereMinusculo() {
		return caractereMinusculo;
	}
}
