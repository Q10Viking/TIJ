import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Parse {

    public static void main(String[] args) {
        if (args.length < 3)
        {
            System.out.printf("Usage: Parse <3-char month> <day> <4-digit year>%n");
            throw new IllegalArgumentException();
        }
        String input = args[0] + ' ' + args[1] + ' ' + args[2];
        try {
            DateTimeFormatter formatter =
                              DateTimeFormatter.ofPattern("MMM d yyyy",Locale.US);
            LocalDate date = LocalDate.parse(input, formatter);
            System.out.printf("%s%n", date);
        } catch (DateTimeParseException exc) {
            System.out.printf("%s is not parsable!%n", input);
            throw exc;       // Rethrow the exception.
        }
        // 'date' has been successfully parsed
    }
}

/*
java Parse Jan 3 2003
2003-01-03
*/
