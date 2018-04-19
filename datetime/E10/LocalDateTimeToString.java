import java.time.LocalDateTime;
import java.time.DateTimeException;
import java.util.Locale;
import java.time.format.DateTimeFormatter;
public class LocalDateTimeToString{
    public static void main(String[] args){
        //get local date-time
        LocalDateTime date = LocalDateTime.now();
        System.out.printf("%s%n",date);  //2018-04-18T21:02:46.155
        //show the encode of operating system
        //System.out.print(System.getProperty("file.encoding"));

        //Chinese -show
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy:::MMM:::dd:::hh:::mm a",Locale.CHINA);
        String str = date.format(format);
        System.out.printf(Locale.CHINA,"%s%n",str);

        //English -show
       format = DateTimeFormatter.ofPattern("yyyy:::MMM:::dd:::hh:::mm a",Locale.US);
       str = date.format(format);
       System.out.printf(Locale.US,"%s%n",str);

    }
}
/*
2018-04-18T21:49:22.830
2018:::四月:::18:::09:::49 下午
2018:::Apr:::18:::09:::49 PM
*/
