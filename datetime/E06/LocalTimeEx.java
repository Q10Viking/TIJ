import java.time.LocalTime;
public class LocalTimeEx{
    public static void main(String[] args) throws Throwable{

        LocalTime thisSec;
        for(;;){
            thisSec = LocalTime.now();
            System.out.printf("%2s:%2s:%02d\n",thisSec.getHour(),thisSec.getMinute(),thisSec.getSecond());
            Thread.sleep(1000);
        }
    }

}
