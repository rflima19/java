package lima.com;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Info {

	private String info;
	private Random random;
	
	private ReentrantReadWriteLock reeReadwriter;
	private ReentrantReadWriteLock.ReadLock readLook;
	private ReentrantReadWriteLock.WriteLock writeLook;
	
	public Info() {
		super();
		this.info = "AAAAAAAAAA";
		this.random = new Random();
		this.reeReadwriter = new ReentrantReadWriteLock();
		this.readLook = this.reeReadwriter.readLock();
		this.writeLook = this.reeReadwriter.writeLock();
	}
	
	public String getInfo() {
		this.readLook.lock();
		try {
			return info;
		} finally {
			this.readLook.unlock();
		}
	}
	
	public void setInfo() {
		this.writeLook.lock();
		try {
			this.info = "";
			for (int i = 0; i < 10; i++) {
				char caracter = (char) (this.random.nextInt(26) + 65);
				this.info += caracter;
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			this.writeLook.unlock();
		}
	}
	
}
