
public class AplicacaoTesteString {

	public static void main(String[] args) {
		
		String str1 = new String("abc");
		String str2 = "abc";
		String str3 = "abc";
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1.equals(str2));
	}
}
