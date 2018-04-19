import java.time.LocalDateTime;

public class LocalDateTimeEx{
    public static void main(String[] args){
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        System.out.printf("%tB",date);
    }
}

/*
2018-04-19T17:23:11.448
四月
*/
