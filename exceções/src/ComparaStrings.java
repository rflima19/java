
public class ComparaStrings {

	public static void main(String[] args) {
		String str1 = "Casa";
		String str2 = "abelha";
		
		try {
			ComparaStrings.compararString(str1, str2);
			ComparaStrings.compararString(str1, null);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void compararString(String str1, String str2) {
		if (str1 == null || str2 == null)
			throw new NullPointerException("refer�ncia da String passada para compara��o � nula");
		
		int resultado = str1.compareTo(str2);

		if (resultado == 0) {
			System.out.println("String " + str1 + " � lexicograficamente igual que a String " + str2);
		} else if (resultado < 0) {
			System.out.println("String " + str1 + " � lexicograficamente menor que a String " + str2);
		} else if (resultado > 0) {
			System.out.println("String " + str1 + " � lexicograficamente maior que a String " + str2);
		}
	}
}
