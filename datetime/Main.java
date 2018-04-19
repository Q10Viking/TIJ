import java.time.Month;
import java.util.Arrays;
import java.time.LocalDate;
public class Main{
    public static void main(String[] args){
        int[] days = new int[12];
        int i=0;
        for(Month m: Month.values())
            days[i++] = m.maxLength();

        System.out.println(Arrays.toString(days));

        LocalDate date=LocalDate.of(2000,5,1);
        int days2 = date.getDayOfYear();
        System.out.println(days2);
    }

}
