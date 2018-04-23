package typeinfo.E01;
import static com.q10viking.util.Print.*;
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
	//Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy
	implements HasBatteries,Waterproof,Shoots{
		FancyToy(){super(1);}

}

public class E01_ToyTest{
	static void printInfo(Class<?> cc){
		print("Class name: "+cc.getName()+
	" is interface? [ "+cc.isInterface()+" ] ");
		print("Simple name: "+cc.getSimpleName());
		print("Canonical name: "+cc.getCanonicalName());
	}
	public static void main(String[] args){
		Class<?> c = null;

		try{
			c = Class.forName("typeinfo.E01.FancyToy");
		}catch(ClassNotFoundException e){
			print("Can't find FancyToy");
			return;
		}
		//deliver Class reference
		printInfo(c);
		print("-------------------");
		for(Class<?> face: c.getInterfaces()){
			printInfo(face);
		}
		print("-------------------");

		Class<?> up = c.getSuperclass();
		Object obj = null;

		try{
			//Requires default constructor
			obj = up.newInstance();
		}catch(InstantiationException e){
			print("Cannot instantiate");
			return;
		}catch(IllegalAccessException e){
			print("Cannot access");
		}

		printInfo(obj.getClass());

	}
}


/*
java typeinfo.E01.E01_ToyTest
Class name: typeinfo.E01.FancyToy is interface? [ false ]
Simple name: FancyToy
Canonical name: typeinfo.E01.FancyToy
-------------------
Class name: typeinfo.E01.HasBatteries is interface? [ true ]
Simple name: HasBatteries
Canonical name: typeinfo.E01.HasBatteries
Class name: typeinfo.E01.Waterproof is interface? [ true ]
Simple name: Waterproof
Canonical name: typeinfo.E01.Waterproof
Class name: typeinfo.E01.Shoots is interface? [ true ]
Simple name: Shoots
Canonical name: typeinfo.E01.Shoots
-------------------
Cannot instantiate

*/
