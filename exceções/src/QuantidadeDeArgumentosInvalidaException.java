

public class QuantidadeDeArgumentosInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final int QUANTIDADE_ARGUMENTOS_VALIDA = 4;
	private int qtdArgumentos;
	private String mensagem;

	public QuantidadeDeArgumentosInvalidaException(int qtdArgumentos, Throwable cause) {
		super(cause);
		this.qtdArgumentos = qtdArgumentos;
	}

	public QuantidadeDeArgumentosInvalidaException(int qtdArgumentos) {
		this.qtdArgumentos = qtdArgumentos;
	}

	public int getQtdArgumentos() {
		return this.qtdArgumentos;
	}

	public String getMensagem() {
		this.mensagem = "Quantidade de " + this.qtdArgumentos + " argumentos é inválida. A quantidade correta é de "
				+ QUANTIDADE_ARGUMENTOS_VALIDA + " argumentos";
		return mensagem;
	}
}
