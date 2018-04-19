import static com.q10viking.util.Print.*;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.format.TextStyle;

public class DayOfWeekEx{
    public static void main(String args[]){
        Locale englishUS = Locale.US;
        Locale chinese = Locale.CHINA;
        DayOfWeek day;
        for(int i=0;i<8;i++){
            day = DayOfWeek.MONDAY.plus(i);
            //Chinese
            String timeOfCN = day.getDisplayName(TextStyle.FULL,chinese);
            //English
            String timeOfUS = day.getDisplayName(TextStyle.FULL,englishUS);
            System.out.printf("%-10s   %-10s\n",timeOfCN,timeOfUS);
        }
    }
}

/*Output
星期一          Monday
星期二          Tuesday
星期三          Wednesday
星期四          Thursday
星期五          Friday
星期六          Saturday
星期日          Sunday
星期一          Monday

*/
