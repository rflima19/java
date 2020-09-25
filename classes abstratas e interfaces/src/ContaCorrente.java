
public class ContaCorrente extends ContaBancaria {

	public ContaCorrente(double saldo) {
		super(saldo);
	}

	@Override
	public double calcularSaldo() {
		double saldoFinal = 0.0;
		final double taxa = 10.0 / 100.0;

		saldoFinal = this.saldo - (this.saldo * taxa);

		return saldoFinal;
	}
}
