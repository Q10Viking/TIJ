import java.time.temporal.Temporal;

import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.LocalDate;
import java.time.DayOfWeek;
/**
 * This temporal adjuster assumes that payday occurs on the 15th
 * and the last day of each month. However, if either of those
 * days lands on a weekend, then the previous Friday is used.
 */
public class PaydayAdjuster implements TemporalAdjuster{

    public Temporal adjustInto(Temporal input){
        LocalDate date = LocalDate.from(input);
        int day;
        if(date.getDayOfMonth()<15){
            day = 15;
        }else{
            day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        }

        date = date.withDayOfMonth(day);
        if(date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY){
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

        }
       // return input.with(date);
        return date;

    }

}
