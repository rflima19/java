
public class AplicacaoContaBancaria {

	public static void main(String[] args) {
		
		ContaBancaria cc = new ContaCorrente(1000.0);
		ContaBancaria ci = new ContaInvestimento(2000.0);
		
		cc.depositar(500.0);
		ci.depositar(200.0);
		cc.sacar(100.0);
		ci.sacar(300.0);
		cc.transferir(800.0, ci);
		
		System.out.println("Saldo final conta corrente: " + cc.calcularSaldo());
		System.out.println("Saldo final conta investimento: " + ci.calcularSaldo());
	}
}
