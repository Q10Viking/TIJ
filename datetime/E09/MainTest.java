import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainTest{
    public static void main(String[] args) throws Exception{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd",Locale.US);
        LocalDate date = LocalDate.parse("2005-Jun-12",formatter);
        System.out.println(date);

        formatter = DateTimeFormatter.ofPattern("yyyy-M-dd",Locale.US);
        date = LocalDate.parse("2018-4-19",formatter);
        System.out.println(date);

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.US);
        date = LocalDate.parse("2018-04-20",formatter);
        System.out.println(date);

        formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd",Locale.US);
        date = LocalDate.parse("2018-September-21",formatter);
        System.out.println(date);
    }

}
