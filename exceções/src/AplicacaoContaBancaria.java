
public class AplicacaoContaBancaria {

	public static void main(String[] args) {

		ContaBancaria c1 = new ContaBancaria(1000.0);
		ContaBancaria c2 = new ContaBancaria(2000.0);

		try {
			c1.depositar(500.0);
			c2.depositar(200.0);
			c1.sacar(100.0);
			c2.sacar(300.0);
			c1.transferir(800.0, c2);
			
			System.out.println("Saldo conta 1: " + c1.getSaldo());
			System.out.println("Saldo conta 2: " + c2.getSaldo());
			
			//c1.depositar(-1);
			//c2.sacar(600000);
			//c1.transferir(-2, c2);
			c2.transferir(100000, c1);
			
		} catch (ValorInvalidoException e) {
			System.err.println(e.getMessage() + ": Valor invalido -> " + e.getValor());
			
		} catch (SaldoInsuficienteException e) {
			System.err.println(e.getMessage() + ": Saldo atual de " + e.getSaldo());
			
		}
	}
}
