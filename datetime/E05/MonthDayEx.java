import java.time.MonthDay;

public class MonthDayEx{
    public static void main(String[] args){
        MonthDay date = MonthDay.now();
        MonthDay date2 = MonthDay.of(2,29);
        boolean validLeapYear = date2.isValidYear(2018);
        System.out.printf("%s  %s%n",date,date2);
        System.out.printf("2018-2-29 is valid: %s%n",validLeapYear);
    }

}

/*
--04-19  --02-29
2018-2-29 is valid: false
*/
