import java.time.temporal.TemporalAdjusters;
import java.time.LocalDate;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

public class TemporalAdjustersEx{
    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        DayOfWeek dotw = date.getDayOfWeek();
        System.out.printf("%s is on a %s%n",date,dotw);

        System.out.printf("first day of Month: %s%n",date.with(TemporalAdjusters.firstDayOfMonth()));

        System.out.printf("first Monday of Month: %s%n",
                date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));

        System.out.printf("last day of Month: %s%n",
                date.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.printf("first day of next Month: %s%n",
                date.with(TemporalAdjusters.firstDayOfNextMonth()));


    }
}

