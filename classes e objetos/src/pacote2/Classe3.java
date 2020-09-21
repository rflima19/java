package pacote2;

import pacote1.Classe1;

public class Classe3 extends Classe1 {

	public Classe3(int v1, int v2, int v3, int v4) {
		super(v1, v2, v3, v4);
	}

	public void m() {
		Classe1 c = new Classe1(1, 2, 3, 4);
		
		int a = this.v4;
	}
}
