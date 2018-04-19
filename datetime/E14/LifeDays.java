import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.Month;
import java.time.LocalDate;
public class LifeDays{
	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1995,Month.AUGUST,16);
		
		Period p = Period.between(birthday,today);
		long p2 = ChronoUnit.DAYS.between(birthday,today);
		System.out.printf("You are "+p.getYears()+" years,"+p.getMonths()+
			" months, and "+p.getDays()+
				" days old.("+p2+" days total");
	}
}