package lima.com;

public class Escritor implements Runnable {
	
	private Info info;

	public Escritor(Info info) {
		super();
		this.info = info;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.info.setInfo();
		}
	}

}
