//https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program
import java.time.Instant;
public class InstantEx{
    public static void main(String[] args) throws Throwable{
        Instant timestamp = Instant.now();
        System.out.println(timestamp);
        System.out.println(System.nanoTime());
        final long startTime = System.nanoTime();
        Thread.sleep(1000);
        final long duration = System.nanoTime()-startTime;
        System.out.println(duration/1000000);
        System.out.println(Instant.now().getNano()-timestamp.getNano());
    }

}
