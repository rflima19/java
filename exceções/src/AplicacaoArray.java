
public class AplicacaoArray {

	public static void main(String[] args) {
		int posicoes = -5;

		int[] array = AplicacaoArray.gararArray(posicoes);
		
		System.out.println(array);
	}

	public static int[] gararArray(int posicoes) {
		if (posicoes < 0) {
			throw new NegativeArraySizeException(
					"Não é possivel gerar um array de " + posicoes + " posições negativas");
		}
		int[] array = new int[posicoes];
		return array;
	}
}
