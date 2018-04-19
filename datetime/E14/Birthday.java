import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Birthday{
	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1995,Month.AUGUST,16);

		LocalDate nextBDay = birthday.withYear(today.getYear());
		//If you birthday has occured this year alreay,add 1 to the year.
		if(nextBDay.isBefore(today) || nextBDay.isEqual(today)){
			nextBDay = nextBDay.plusYears(1);
		}

		Period p = Period.between(today,nextBDay);
		long p2 = ChronoUnit.DAYS.between(today,nextBDay);
		System.out.printf("There are "+p.getMonths()+" months,and "+
			p.getDays()+" days util your next birthday.("+
			p2+" total)");

	}
}
