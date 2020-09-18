
public class Fatorial {

	public static void main(String[] args) {
		Fatorial f = new Fatorial();
		
		long num = 15L;
		long fat = 0L;
		fat = f.fat(num);
		System.out.println(num + "! = " + fat);
		
		// fatorial utilizando a forma iterativa (usando estruturas de repetição)
		num = 15L;
		fat = 1L;
		long cont = num;
		while (cont > 0) {
			fat *= cont;
			cont--;
		}
		System.out.println(num + "! = " + fat);
	}
	
	// fatorial de forma recursiva
	public long fat(long num) {
		if (num == 0) {
			return 1L;
		}
		return num * fat(num - 1);
	}
}
