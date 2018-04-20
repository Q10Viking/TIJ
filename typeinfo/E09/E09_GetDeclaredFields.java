//package typeinfo.E09;
import java.util.*;
import java.lang.reflect.*;
import static com.q10viking.util.Print.*;
interface Iface{
	int i = 47;
	void f();
}

class Base implements Iface{
	String s;
	double d;
	public void f(){
		System.out.println("Base.f");
	}
}

class Composed{
	Base b;
}

class Derived extends Base{
	Composed c;
	String s;
}


public class E09_GetDeclaredFields{
	static Set<Class<?>> alreadyDisplayed = 
			new HashSet<Class<?>>();
	static void printClasses(Class<?> c){
		//getSuperclass() return null on Object;
		if(c == null) return;
		print(c.getName());
		Field[] fields = c.getDeclaredFields();
		if(fields.length != 0){
			print("Fields: ");
		}
		for(Field fld: fields){
			print("  "+fld);
		}
		
		for(Field fld: fields){
			Class<?> k = fld.getType();
			if(!alreadyDisplayed.contains(k)){
				printClasses(k);
				alreadyDisplayed.add(k);
			}
		}
		
		//Produce the interfaces that this class
		//implements
		for(Class<?> k: c.getInterfaces()){
			print("Interface: "+k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}
	
    public static void main(String[] args) throws Exception{
		for(int i=0;i<args.length;i++){
			print("Displaying "+args[i]);
			printClasses(Class.forName(args[i]));
			if(i<args.length-1)
				System.out.println("=========");
		}
    }
}

/*
java E09_GetDeclaredFields Derived                                                                                       
Displaying Derived                                                                               
Derived                                                                                          
Fields:                                                                                          
  Composed Derived.c                                                                             
  java.lang.String Derived.s                                                                     
Composed                                                                                         
Fields:                                                                                          
  Base Composed.b                                                                                
Base                                                                                             
Fields:                                                                                          
  java.lang.String Base.s                                                                        
  double Base.d                                                                                  
java.lang.String                                                                                 
Fields:                                                                                          
  private final char[] java.lang.String.value                                                    
  private int java.lang.String.hash                                                              
  private static final long java.lang.String.serialVersionUID                                    
  private static final java.io.ObjectStreamField[] java.lang.String.serialPersistentFields       
  public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER               
[C                                                                                               
Interface: java.lang.Cloneable                                                                   
Interface: java.io.Serializable                                                                  
java.lang.Object                                                                                 
int                                                                                              
long                                                                                             
[Ljava.io.ObjectStreamField;                                                                     
Interface: java.lang.Cloneable                                                                   
Interface: java.io.Serializable                                                                  
java.lang.Object                                                                                 
java.util.Comparator                                                                             
Interface: java.io.Serializable                                                                  
Interface: java.lang.Comparable                                                                  
Interface: java.lang.CharSequence                                                                
java.lang.Object                                                                                 
double                                                                                           
Interface: Iface                                                                                 
java.lang.Object                                                                                 
java.lang.Object                                                                                 
Base                                                                                             
Fields:                                                                                          
  java.lang.String Base.s                                                                        
  double Base.d                                                                                  
Interface: Iface                                                                                 
java.lang.Object     
*/                                                                            