
public class Data {

	public static final int FORMATO_12H = 12;
	public static final int FORMATO_24H = 24;

	private int dia;
	private int mes;
	private int ano;
	private int hora;
	private int minuto;
	private int segundo;

	private boolean horaConfigurada = false;

	public Data(int dia, int mes, int ano) {
		super();

		boolean dataValida = true;

		if (ano >= 1500 && ano <= 2050) {
			switch (mes) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				if (dia < 1 || dia > 31) {
					dataValida = false;
				}
			}
			case 4, 6, 9, 11 -> {
				if (dia < 1 || dia > 30) {
					dataValida = false;
				}
			}
			case 2 -> {
				if (dia < 1 || dia > 28) {
					dataValida = false;
				}
			}
			default -> {
				dataValida = false;
			}
			}
		} else {
			dataValida = false;
		}

		if (dataValida == false) {
			throw new RuntimeException("Data (" + dia + "/" + mes + "/" + ano + ")  inválida");
		} else {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}

	}

	public Data(int dia, int mes, int ano, int hora, int minuto, int segundo) {
		this(dia, mes, ano);

		boolean horaValida = true;

		if (hora < 0 || hora > 23) {
			horaValida = false;
		}
		if (minuto < 0 || minuto > 59) {
			horaValida = false;
		}
		if (segundo < 0 || segundo > 59) {
			horaValida = false;
		}

		if (horaValida == false) {
			throw new RuntimeException("Hora (" + hora + ":" + minuto + ":" + segundo + ") inválida");
		} else {
			this.hora = hora;
			this.minuto = minuto;
			this.segundo = segundo;
			this.horaConfigurada = true;
		}
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void imprimir(int formato) {
		if (horaConfigurada == false) {
			System.out.printf("%02d/%02d/%02d\n", this.dia, this.mes, this.ano);
		} else {
			if (formato == Data.FORMATO_12H) {
				if (this.hora < 11) {
					System.out.printf("%02d/%02d/%02d %02d:%02d:%02d AM\n", this.dia, this.mes, this.ano, this.hora,
							this.minuto, this.segundo);
				} else {
					System.out.printf("%02d/%02d/%02d %02d:%02d:%02d PM\n", this.dia, this.mes, this.ano, this.hora % 12,
							this.minuto, this.segundo);
				}
			} else if (formato == Data.FORMATO_24H) {
				System.out.printf("%02d/%02d/%02d %02d:%02d:%02d\n", this.dia, this.mes, this.ano, this.hora, this.minuto,
						this.segundo);
			} else {
				System.out.println("Formato inválido");
			}
		}
	}
}
