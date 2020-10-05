
public class Matematica {

	public enum TipoAngulo {
		GRAUS("°C"), RADIANOS("RAD");

		private String simbolo;

		private TipoAngulo(String simbolo) {
			this.simbolo = simbolo;
		}

		public String getSimbolo() {
			return simbolo;
		}
		
		public Double toRadians(Double degrees) {
			return Math.toRadians(degrees);
		}
		
		public Double toDegrees(Double radians) {
			return Math.toDegrees(radians);
		}
	}

	public static Double converterAngulo(Double angulo, Matematica.TipoAngulo tipo) {
		if (angulo == null) {
			throw new IllegalArgumentException("Valor do ângulo nulo");
		}
		Double resultado = null;
		if (tipo == Matematica.TipoAngulo.GRAUS) {
//			resultado = Math.toRadians(angulo);
			resultado = tipo.toRadians(angulo);
		} else if (tipo == Matematica.TipoAngulo.RADIANOS) {
//			resultado = Math.toDegrees(angulo);
			resultado = tipo.toDegrees(angulo);
		}
		return resultado;
	}
	
	public static Integer converterBinarioParaDecimal(String numBinario) {
		if (numBinario == null) {
			throw new IllegalArgumentException("Parâmetro de String nulo");
		}
		Integer resultado = Integer.valueOf(numBinario, 2);
		return resultado;
	}
	
	public static Integer somar(Integer n1, Integer n2, Integer n3) {
		if (n1 == null || n2 == null || n3 == null) {
			throw new IllegalArgumentException("Parâmetro Integer nulo");
		}
		Integer resultado = n1 + n2 + n3;
		return resultado;
	}
}
