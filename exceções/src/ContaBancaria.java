
public class ContaBancaria {

	private double saldo;

	public ContaBancaria(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void depositar(double valor) throws ValorInvalidoException {
		if (valor <= 0.0) {
			throw new ValorInvalidoException("Valor de deposito inválido", valor);
		}

		this.saldo += valor;
	}

	public void sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException {
		if (valor <= 0.0) {
			throw new ValorInvalidoException("Valor de saque inválido", valor);
		}

		if (this.saldo - valor < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente", this.saldo);
		}

		this.saldo -= valor;
	}

	public void transferir(double valor, ContaBancaria c) throws ValorInvalidoException, SaldoInsuficienteException {
		this.sacar(valor);
		c.depositar(valor);
	}
}
