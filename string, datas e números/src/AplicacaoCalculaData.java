import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class AplicacaoCalculaData {

	public static void main(String[] args) {
		
		LocalDate ldNow = LocalDate.now();
		
		LocalDate ldBorn1 = LocalDate.of(1955, Month.MAY, 19);
		Period period = Period.between(ldBorn1, ldNow);
		System.out.println("Anos: " + period.getYears());
		System.out.println("Meses: " + period.getMonths());
		System.out.println("Dias: " + period.getDays());
		
		LocalDate ldBorn2 = LocalDate.of(1955, Month.MAY, 19);
		System.out.println("\nAnos: " + ChronoUnit.YEARS.between(ldBorn2, ldNow));
		System.out.println("Meses: " + ChronoUnit.MONTHS.between(ldBorn2, ldNow));
		System.out.println("Dias: " + ChronoUnit.DAYS.between(ldBorn2, ldNow));
		
		LocalDateTime ldBorn3 = LocalDateTime.of(1994, Month.SEPTEMBER, 29, 8, 15, 0);
		LocalDateTime ldtNow = LocalDateTime.now();
		System.out.println("\nAnos: " + ChronoUnit.YEARS.between(ldBorn3, ldtNow));
		System.out.println("Meses: " + ChronoUnit.MONTHS.between(ldBorn3, ldtNow));
		System.out.println("Dias: " + ChronoUnit.DAYS.between(ldBorn3, ldtNow));
		System.out.println("Horas: " + ChronoUnit.HOURS.between(ldBorn3, ldtNow));
		System.out.println("Minutos: " + ChronoUnit.MINUTES.between(ldBorn3, ldtNow));
		System.out.println("Segundos: " + ChronoUnit.SECONDS.between(ldBorn3, ldtNow));
		
		Year nextYear = Year.now().plusYears(1);
		LocalDateTime ldNextBirthday = LocalDateTime.of(nextYear.getValue(), Month.SEPTEMBER, 29, 8, 15, 0);
		System.out.println("\nAnos: " + ChronoUnit.YEARS.between(ldtNow, ldNextBirthday));
		System.out.println("Meses: " + ChronoUnit.MONTHS.between(ldtNow, ldNextBirthday));
		System.out.println("Dias: " + ChronoUnit.DAYS.between(ldtNow, ldNextBirthday));
		System.out.println("Horas: " + ChronoUnit.HOURS.between(ldtNow, ldNextBirthday));
		System.out.println("Minutos: " + ChronoUnit.MINUTES.between(ldtNow, ldNextBirthday));
		System.out.println("Segundos: " + ChronoUnit.SECONDS.between(ldtNow, ldNextBirthday));
		
		LocalTime lt3HAM = LocalTime.of(3, 0, 0);
		LocalTime ltNow = LocalTime.now();
		System.out.println("\nHoras: " + ChronoUnit.HOURS.between(lt3HAM, ltNow));
		System.out.println("Minutos: " + ChronoUnit.MINUTES.between(lt3HAM, ltNow));
		System.out.println("Segundos: " + ChronoUnit.SECONDS.between(lt3HAM, ltNow));
	}
}
