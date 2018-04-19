import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainTest{
    public static void main(String[] args) throws Exception{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd",Locale.US);
        LocalDate date = LocalDate.parse("2005-Jun-12",formatter);
        System.out.println(date);
    }

}
