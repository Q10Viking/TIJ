import java.time.Month;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.util.Locale;
import java.time.Year;
public class NextPayday{
    public static void main(String[] args){
        Month month=null;
        LocalDate date = null;
        DateTimeFormatter format;
        String out = null;
        if(args.length<2){
            System.out.printf("Usage: NextPayday <month><day>%n");
            throw new IllegalArgumentException();
        }
        try{
            //Returns the enum constant of this type with the specified name.
            month = Month.valueOf(args[0].toUpperCase());
        }catch(IllegalArgumentException exc){
            System.out.printf("%s is not a valid month.%n",args[0]);
            throw exc;
        }
        int day = Integer.parseInt(args[1]);
        //year to date
        try{
            date = Year.now().atMonth(month).atDay(day);
        }catch(DateTimeException exc){
            System.out.printf("%s %s is not a valid date.%n",month,day);
            throw exc;
        }

        LocalDate nextPayday = date.with(new PaydayAdjuster());
        try{
            format = DateTimeFormatter.ofPattern("yyyy MMM d",Locale.US);
            out = date.format(format);
            System.out.printf("Given the date: %s%n",out);
            out = nextPayday.format(format);
            System.out.printf("the next payday: %s%n",out);
        }catch(DateTimeException exc){
            System.out.printf("%s can't be formatted!%n",out);
            throw exc;
        }
    }
}

/*
javac NextPayday April 18
Given the date: 2018 Apr 18
the next payday: 2018 Apr 30
*/
