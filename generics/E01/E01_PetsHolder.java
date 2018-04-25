package generics.E01;
import typeinfo.pets2.*;

public class E01_PetsHolder{
	public static void main(String[] args){
		Holder3<Pet> h3 = new Holder3<Pet>(new Mouse("Mickey"));
		System.out.println(h3.get());
	}
	
}
/*
java generics.E01.E01_PetsHolder
Mouse Mickey
*/