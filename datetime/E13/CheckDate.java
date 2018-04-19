import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.DateTimeException;

public class CheckDate{
    public static void main(String[] args){
        Month month = null;
        LocalDate date = null;
        if(args.length<2){
            System.out.printf("Usage: CheckDate <month><day>%n");
            throw new IllegalArgumentException();
        }
        try{
            month = Month.valueOf(args[0].toUpperCase());
        }catch(IllegalArgumentException exc){
            System.out.printf("%s is not a valid month.%n",args[0]);
            throw exc;
        }

        int day = Integer.parseInt(args[1]);

        try{
            date = LocalDate.of(Year.now().getValue(),month,day);
        }catch(DateTimeException exc){
            System.out.printf("%s %s is not a valid date.%n",month,day);
            throw exc;
        }

        //Invoking the query without using a lamba expression.
        Boolean isFamilyVacation = date.query(new FamilyVacations());
        
		//Invoking the query using a lambda expression.
		Boolean isFamilyBirthday = date.query(FamilyBirthdays::isFamilyBirthday);
		
		
		if(isFamilyVacation.booleanValue() || isFamilyBirthday.booleanValue()){
            System.out.printf("%s is an important date!%n",date);
        }else{
            System.out.printf("%s is not an imporant date.%n",date);
        }
		
		
    }
}
