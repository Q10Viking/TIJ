package typeinfo.E02;
import static com.q10viking.util.Print.*;



interface HasCPU{}

class FancierToy extends FancyToy implements HasCPU{}


public class E02_ToyTest2{
	static void printInfo(Class<?> cc){
		print("Class name: "+cc.getName()+
			" is interface? [ "+cc.isInterface()+" ]");
		print("Simple name: "+cc.getSimpleName());
		print("Canonical name: "+cc.getCanonicalName());
	}
	
	
    public static void main(String[] args){
		Class<?> c = null;
		try{
			c = Class.forName("typeinfo.E02.FancierToy");
		}catch(ClassNotFoundException e){
			print("Can't find FancierToy");
			System.exit(1);
		}
		
		printInfo(c);
		
		for(Class<?> face: c.getInterfaces()){
			printInfo(face);
		}
		
		Class<?> up = c.getSuperclass();
		
		Object obj = null;
		try{
			obj = up.newInstance();
		}catch(InstantiationException e){
			print("Cannot instantiate");
			System.exit(1);
		}catch(IllegalAccessException e){
			print("Cannot access");
			System.exit(1);
		}	
		printInfo(obj.getClass());
    }
}

/*
java typeinfo.E02.E02_ToyTest2                         
Class name: typeinfo.E02.FancierToyis interface? [ false ]
Simple name: FancierToy                                   
Canonical name: typeinfo.E02.FancierToy                   
Class name: typeinfo.E02.HasCPUis interface? [ true ]     
Simple name: HasCPU                                       
Canonical name: typeinfo.E02.HasCPU                       
Class name: typeinfo.E02.FancyToyis interface? [ false ]  
Simple name: FancyToy                                     
Canonical name: typeinfo.E02.FancyToy                     
*/




