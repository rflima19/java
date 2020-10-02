
public class AplicacaoProcessaString {

	public static void main(String[] args) {
		AplicacaoProcessaString appProcessaString = new AplicacaoProcessaString();
		System.out.println(appProcessaString.processar(null));
		System.out.println(appProcessaString.processar("ab"));
		System.out.println(appProcessaString.processar("abcdefg"));
		System.out.println(appProcessaString.processar("Java"));
	}
	
	public String processar(String str) {
		if (str == null) {
			return null;
		}
		String strProcessada = str.toUpperCase();
		if (strProcessada.length() > 3) {
			StringBuilder strb = new StringBuilder(strProcessada.substring(0, 3));
			strb.reverse();
			strProcessada = strb.toString() + strProcessada.substring(3);
		}
		return strProcessada;
	}
}
