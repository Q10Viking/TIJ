import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
//Display all of the Mondays in the current year and the specified mon
public class ListMondays{
    public static void main(String[] args){
        Month month = null;
        if(args.length<1){
            System.out.printf("Usage: ListMondays <month> %n");
            throw new IllegalArgumentException();
        }

        try{
            month = Month.valueOf(args[0].toUpperCase());
        }catch(IllegalArgumentException exc){
            System.out.printf("%s is not a valid month.%n",args[0]);
            throw exc;
        }

        System.out.printf("For the month of %s%n",month);
        LocalDate date = Year.now().atMonth(month).atDay(1).
            with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        Month mi = date.getMonth();
        while(mi == month){
            System.out.printf("%s%n",date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();
        }
    }

}

/*
λ java ListMondays April
For the month of APRIL
2018-04-02
2018-04-09
2018-04-16
2018-04-23
2018-04-30
 */
