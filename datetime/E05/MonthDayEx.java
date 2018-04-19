import java.time.MonthDay;

public class MonthDayEx{
    public static void main(String[] args){
        MonthDay date = MonthDay.now();
        MonthDay date2 = MonthDay.of(2,27);
        System.out.printf("%s \n %s",date,date2);
    }

}
