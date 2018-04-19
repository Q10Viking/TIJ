import java.time.temporal.TemporalAdjusters;
import java.time.LocalDate;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

public class TemporalAdjustersEx{
    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        DayOfWeek dotw = date.getDayOfWeek();

        System.out.printf("%s is on a %s%n",date,dotw);   //2018-04-19 is on a THURSDAY

        System.out.printf("first day of Month: %s%n",date.with(TemporalAdjusters.firstDayOfMonth()));  //first day of Month: 2018-04-01

        System.out.printf("first Monday of Month: %s%n",
                date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));   //first Monday of Month: 2018-04-02

        System.out.printf("last day of Month: %s%n",
                date.with(TemporalAdjusters.lastDayOfMonth())); //last day of Month: 2018-04-30

        System.out.printf("first day of next Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfNextMonth())); //first day of next Month: 2018-05-01


    }
}

