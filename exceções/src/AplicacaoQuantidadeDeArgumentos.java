public class AplicacaoQuantidadeDeArgumentos {

	public static void main(String[] args) throws QuantidadeDeArgumentosInvalidaException {
		try {
			if (args.length < 4) {
				throw new QuantidadeDeArgumentosInvalidaException(args.length);
			}
			System.out.println("Quantidade de argumentos passados a aplicação: " + args.length);
		} catch (QuantidadeDeArgumentosInvalidaException e) {
			System.err.println(e.getMensagem());
			e.printStackTrace();
		}
	}
}
