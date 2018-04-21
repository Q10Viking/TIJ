import java.lang.reflect.*;
import java.util.regex.*;
import static com.q10viking.util.Print.*;

public class ShowMethods{
    private static String usage = "usage:\n"+
                    "Show methods qualified.class.name\n"+
                    "To show all methods in class or:\n"+
                    "Show methods qualified.class.name word\n"+
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args){
        if(args.length<1){
            print(usage);
            System.exit(0);
        }

        int lines = 0;
        try{
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if(args.length == 1){
                for(Method method: methods){
                    print(p.matcher(method.toString()).replaceAll(""));
                }
                for(Constructor ctor: ctors)
                    print(p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length+ctors.length;
            }else{
                for(Method method: methods)
                    if(method.toString().indexOf(args[1]) !=-1){
                        print(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }

                for(Constructor ctor: ctors)
                    if(ctor.toString().indexOf(args[1]) != -1){
                        print(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        }catch(ClassNotFoundException e){
            print("No such class "+e);
        }
    }
}

/*

java ShowMethods ShowMethods
public static void main(String[])
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public ShowMethods()

*/


/*

java ShowMethods ShowMethods toString
public String toString()

*/
