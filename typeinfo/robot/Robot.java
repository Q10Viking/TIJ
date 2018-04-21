package typeinfo.robot;
import java.util.*;
import typeinfo.util.Null;
public interface Robot{
    String name();
    String model();
    List<Operation> operations();
    class Test{
        public static void test(Robot r){
            if(r instanceof Null)
                System.out.println("[NULL Robot]");
            System.out.println("Robot name: "+r.name());
            System.out.println("Robot model: "+r.model());
            for(Operation operation: r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
