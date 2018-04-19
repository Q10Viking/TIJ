/*Write an example that, for a given year,
reports the length of each month within that year.
*/
import java.time.Year;
import java.time.Month;
import java.time.YearMonth;
import java.time.DateTimeException;

public class MonthsInYear{
	public static void main(String[] args){
		if(args.length<1){
			System.out.println("Usage: MonthsInYear <year>");
			throw new IllegalArgumentException();
		}
		int year = 0;
		try{
			year = Integer.parseInt(args[0]);
		}catch(NumberFormatException nexc){
			System.out.printf("%s is not a properly formatted number%n",args[0]);
			throw nexc;
		}

		try{
			Year test = Year.of(year);
		}catch(DateTimeException exc){
			System.out.printf("%s is not a valid year.%n",year);
			throw exc;
		}

		System.out.printf("For the year %d:%n",year);
		for(Month month: Month.values()){
			YearMonth ym = YearMonth.of(year,month);
			System.out.printf("%-20s: %s days%n",month,ym.lengthOfMonth());
		}

	}
}
