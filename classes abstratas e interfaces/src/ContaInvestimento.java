
public class ContaInvestimento extends ContaBancaria {

	public ContaInvestimento(double saldo) {
		super(saldo);
	}

	public double calcularSaldo() {
		double saldoFinal = 0.0;
		final double taxa = 5.0 / 100.0;

		saldoFinal = this.saldo + (this.saldo * taxa);

		return saldoFinal;
	}
}
