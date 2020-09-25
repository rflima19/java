
public abstract class ContaBancaria {

	protected double saldo;
	
	public ContaBancaria(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public abstract double calcularSaldo();
	
	public void depositar(double valor) {
		if (valor < 0) {
			return;
		}
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		if (valor > this.saldo) {
			return;
		}
		this.saldo -= valor;
	}
	
	public void transferir(double valor, ContaBancaria c) {
		if (valor > this.saldo) {
			return;
		}
		this.sacar(valor);
		c.depositar(valor);
	}
}
