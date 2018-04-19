import java.time.LocalDateTime;
import java.util.Locale;
public class TimeFormat{
    public static void main(String[] args){
        LocalDateTime datetime = LocalDateTime.now();
        System.out.printf(Locale.US,"%1$tY %<tB  %<te%n",datetime); //2018 April  19
        System.out.format(Locale.US,"%1$tY %<tb  %<te%n",datetime); //2018 Apr  19
        System.out.printf(Locale.US,"%1$tH : %<tM : %<tS%n",datetime); //20 : 36 : 51
        System.out.format(Locale.US,"%1$tI : %<tM : %<tS  %<tp%n",datetime); //08 : 36 : 51  pm

    }
}
