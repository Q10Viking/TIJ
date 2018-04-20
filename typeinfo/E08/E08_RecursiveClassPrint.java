/****************** Exercise 8 ******************
* Write a method that takes an object and
* recursively prints all the classes in that
* object's hierarchy.
***********************************************/
//package typeinfo.E08;
import static com.q10viking.util.Print.*;

public class E08_RecursiveClassPrint{
	static void printClasses(Class<?> c){
		//getSuperclass()  return null on Object£º
		if(c == null) return;
		print(c.getName());
		//Produces the interfaces that this class implements
		for(Class<?> k: c.getInterfaces()){
			print("Interface: "+k.getName());
		}
		//recursive
		printClasses(c.getSuperclass());
	}

    public static void main(String[] args) throws Exception{
		for(int i=0;i<args.length;i++){
			print("Displaying  "+args[i]);
			printClasses(Class.forName(args[i]));
			if(i<args.length-1)
				print("=======================");
		}
    }
}

/*
java E08_RecursiveClassPrint Circle   
Displaying  Circle                       
Circle                                   
Shape                                    
java.lang.Object                         
 */                                      








