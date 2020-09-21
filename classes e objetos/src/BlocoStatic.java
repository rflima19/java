
public class BlocoStatic {

	public static int x = 0;

	static {
		BlocoStatic.x++;
		System.out.println("Classe referenciada: " + BlocoStatic.x);
	}
	
	{
		System.out.println("Classe instanciada.");
	}

	public BlocoStatic() {
		super();
		System.out.println("Novo objeto.");
	}

	public void m1() {
		System.out.println("Chamada método m1()");
	}
	
	public static void m2() {
		System.out.println("Chamada método m2()");
	}
	
	public static void main(String[] args) {
		System.out.println("x = " + BlocoStatic.x);
		BlocoStatic.m2();
		
		BlocoStatic bs1 = new BlocoStatic();
		bs1.m1();
		
		BlocoStatic bs2 = new BlocoStatic();
		bs2.m1();
	}
}
