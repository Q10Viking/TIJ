import static com.q10viking.util.Print.*;
import java.util.Locale;
import java.time.Month;
import java.time.format.TextStyle;

public class MonthEx{
    public static void main(String args[]){
        Locale englishUS = Locale.US;
        Locale chinese = Locale.CHINA;
        Month month;
        for(int i=0;i<13;i++){
            month = Month.JANUARY.plus(i);
            int days = month.maxLength();
            //Chinese
            String timeOfCN = month.getDisplayName(TextStyle.FULL,chinese);
            //English
            String timeOfUS = month.getDisplayName(TextStyle.FULL,englishUS);
            System.out.printf("%-10s %-10s %-5d\n",timeOfCN,timeOfUS,days);
           // System.out.printf("%-10s %-10s %-5d\n",timeOfUS,timeOfUS,days);
        }
    }
}

/*Output
一月         January    31
二月         February   29
三月         March      31
四月         April      30
五月         May        31
六月         June       30
七月         July       31
八月         August     31
九月         September  30
十月         October    31
十一月        November   30
十二月        December   31
一月         January    31

*/
