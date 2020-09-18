
public class AplicacaoSistemaEscolar {

	public static void main(String[] args) {
		Prova p1 = new Prova(4.0, 2.5);
		Prova p2 = new Prova(1.0, 7.0);
		Aluno a1 = new Aluno(p1, p2);
		
		Prova p3 = new Prova(6.5, 3.5);
		Prova p4 = new Prova(0.0, 3.0);
		Aluno a2 = new Aluno(p3, p4);
		
		Prova p5 = new Prova(5.0, 4.0);
		Prova p6 = new Prova(6.0, 1.5);
		Aluno a3 = new Aluno(p5, p6);
		
		Turma t = new Turma(a1, a2, a3);
		
		System.out.println("Média aluno 1: " + a1.calcularMedia());
		System.out.println("Média aluno 2: " + a2.calcularMedia());
		System.out.println("Média aluno 3: " + a3.calcularMedia());
		
		System.out.printf("Média da turma: %.2f", t.calcularMedia());
	}
}
