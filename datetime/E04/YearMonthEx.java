import java.time.YearMonth;
import java.time.Month;
public class YearMonthEx{
    public static void main(String[] args){
        YearMonth date = YearMonth.now();
        System.out.printf("%s: %s%n",date,date.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2010,Month.FEBRUARY);
        System.out.printf("%s: %s%n",date2,date2.lengthOfMonth());
    }

}
