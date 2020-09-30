
public class AplicacaoAnalisaString {

	public static void main(String[] args) {

		String str = "LINGUAGEM JAVA";
		
		try {
			boolean resultado = AplicacaoAnalisaString.validarStringMaiuscula(str);
			System.out.println("String " + str + " é válida?: " + resultado);
		} catch (CaractereMinusculoException e) {
			System.out.println(e.getMessage() + ": " + e.getCaractereMinusculo());
		} catch (CaractereNumericoException e) {
			System.out.println(e.getMessage() + ": " + e.getCaractereNumerico());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * recebe um string como parâmetro e verifica se o mesmo é composto apenas por
	 * caracteres maiúsculos.
	 */
	public static boolean validarStringMaiuscula(String str)
			throws CaractereMinusculoException, CaractereNumericoException {
		if (str == null) {
			throw new NullPointerException("Referência nula");
		}
		char[] caracteres = str.toCharArray();
		for (char c : caracteres) {
			if (Character.isDigit(c)) {
				// return false;
				throw new CaractereNumericoException(c, "Caractere númerico encontrado");
			}

			if (Character.isLowerCase(c)) {
				// return false;
				throw new CaractereMinusculoException(c, "Caractere minúsculo encontrado");
			}

			// Character.isLetter(c);
			// Character.isUpperCase(c);
		}
		return true;
	}
}
