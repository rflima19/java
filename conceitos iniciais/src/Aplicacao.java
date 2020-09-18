public class Aplicacao {
	
	public static void main(String[] args) {
		
		// Vari�veis
		boolean bvar = false;
		byte btvar = 10;
		short svar = 10;
		char cvar = 'a';
		int ivar = 10;
		long lvar = 10L;
		float fvar;
		fvar = 1.0f;
		double dvar;
		dvar = 1.0;
		
		cvar = '\u0061'; // nota��o unicode
		
		ivar = 012; // atribui��o de literal octal
		ivar = 0xA; // atribui��o de literal hexadecimal
		ivar = 0b1010; // atribui��o de literal bin�rio
		
		ivar = ivar + 1;
		
		ivar += 1;
		
		++ivar;
		
		ivar = (int)dvar + ivar;
		
		dvar = (lvar + svar) / 2;
		
		ivar = (int)(5 * 2.0);
		
		ivar = 5 * (int)2.0;
		
		System.out.println("Boolean = " + bvar);
		System.out.println("Byte = " + btvar);
		System.out.println("Short = " + svar);
		System.out.println("Char = " + cvar);
		System.out.println("Int = " + ivar);
		System.out.println("Long = " + lvar);
		System.out.println("Float = " + fvar);
		System.out.println("Double = " + dvar);
		
		
		// A partir do Java 10 - identificador restrito var
		var vvar = 10;
		
		vvar = 100;
		
		vvar = (int)100.0;
		
		System.out.println("Variavel definida com palavra chave var = " + vvar);
		
		// Usando caracteres sublinhados em literais num�ricos
		int cep = 12345_678;
		int codigo = 12_7_____89_10;
		
		System.out.println("Cep = " + cep);
		System.out.println("C�digo = " + codigo);
		
		// Operadores
		boolean a = true;
		boolean b = false;
		
		System.out.println(a && b);
		System.out.println(a || b);
		System.out.println(!a || b);
		System.out.println(!b && (10 >= 100) || a);
		System.out.println(10 != 10 || a && 54 >= 23);
		System.out.println(++ivar);
		System.out.println(--ivar);
		System.out.println(ivar++);
	} 
	
}