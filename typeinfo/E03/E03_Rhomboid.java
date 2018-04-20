package typeinfo.E03;
import java.util.*;
class Rhomboid extends Shape{
	public String toString(){
		return "Rhomboid";
	}
}


public class E03_Rhomboid{
    public static void main(String[] args){
		List<Shape> shapes = Arrays.asList(
			new Circle(),new Square(),new Triangle(),new Rhomboid());
		for(Shape shape: shapes){
			shape.draw();
		}
		//Upcase to Shape
		Shape shape = new Rhomboid();
		//Download to Rhomboid
		Rhomboid r = (Rhomboid)shape;
		//Download to Circle.Succeeds at compile time,
		//but faileds at runtime with a ClasCastException;
		Circle c = (Circle)shape;
    }
}
