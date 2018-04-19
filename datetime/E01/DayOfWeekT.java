import java.time.DayOfWeek;

public class DayOfWeekT{
    public static void main(String[] args){
        //error!!!
        //DayOfWeek.of(0);

        for(int i=1;i<8;i++){
            DayOfWeek date = DayOfWeek.of(i);
            System.out.printf("i=%d %s value=%d%n",i,date,date.getValue());
        }
    }
}

/*
i=1 MONDAY value=1
i=2 TUESDAY value=2
i=3 WEDNESDAY value=3
i=4 THURSDAY value=4
i=5 FRIDAY value=5
i=6 SATURDAY value=6
i=7 SUNDAY value=7
*/
