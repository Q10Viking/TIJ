package typeinfo.E04;

public class E04_Instanceof{
    public static void main(String[] args){
		//Upcast to shape
		Shape shape = new Rhomboid();
		//Download to Rhomboid
		Rhomboid r = (Rhomboid)shape;
		//Test before Downloadcasting
		Circle c = null;
		if(shape instanceof Circle){
			c = (Circle)shape;
		}else{
			System.out.println("Shape is not a Circle");
		}
		
    }
}


/*
java typeinfo.E04.E04_Instanceof
Shape is not a Circle
*/