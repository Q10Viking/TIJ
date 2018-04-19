import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class LocalDateEx{
    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
        DayOfWeek nowOfWeek = date.getDayOfWeek();
        LocalDate nextWed = date.with(adj);
        System.out.printf("%s %s\n",date,nowOfWeek);
        System.out.printf("For the date of %s,the next Wednesday is %s\n",
                            date,nextWed);
    }

}

/*
2018-04-19 THURSDAY
For the date of 2018-04-19,the next Wednesday is 2018-04-25
*/
