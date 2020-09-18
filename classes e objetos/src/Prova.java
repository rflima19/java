
public class Prova {

	private double notaParte1;
	private double notaParte2;
	
	public Prova(double notaParte1, double notaParte2) {
//		this.notaParte1 = notaParte1;
//		this.notaParte2 = notaParte2;
		this.setNotaParte1(notaParte1);
		this.setNotaParte2(notaParte2);
	}

	public double getNotaParte1() {
		return notaParte1;
	}

	public void setNotaParte1(double notaParte1) {
		if (notaParte1 < 0) {
			this.notaParte1 = 0.0;
		} else if (notaParte1 > 10.0) {
			this.notaParte1 = 10.0;
		} else {
			this.notaParte1 = notaParte1;
		}
	}

	public double getNotaParte2() {
		return notaParte2;
	}

	public void setNotaParte2(double notaParte2) {
		if (notaParte2 < 0) {
			this.notaParte2 = 0.0;
		} else if (notaParte2 > 10.0) {
			this.notaParte2 = 10.0;
		} else {
			this.notaParte2 = notaParte2;
		}
	}
	
	public double calcularNotaTotal() {
		return this.notaParte1 + this.notaParte2;
	}
}
