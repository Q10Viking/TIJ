import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.DateTimeException;
//有时区的时间转换

public class Flight{
    public static void main(String[] args){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a",Locale.US);
        //Leaving from San Francisco on July 20,2013,at 7:30 pm
        LocalDateTime leaving = LocalDateTime.of(2013,Month.JULY,20,19,30);

        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving,leavingZone);
        try{
            String out1 = departure.format(format);
            System.out.printf("LEAVING: %s (%s)%n",out1,leavingZone);
        }catch(DateTimeException ex){
            System.out.printf("%s can't be formatted!%n",departure);
            throw ex;
        }
        //Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);

        try{
            String out2 = arrival.format(format);
            System.out.printf("Arriving: %s (%s)%n",out2,arrivingZone);
        }catch(DateTimeException ex){
            System.out.printf("%s can't be formatted!%n",arrival);
            throw ex;
        }
    }
}
