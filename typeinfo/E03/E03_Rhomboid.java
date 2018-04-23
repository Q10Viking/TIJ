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

/*
java typeinfo.E03.E03_Rhomboid
Circle.draw()
Square.draw()
Triangle.draw()
Rhomboid.draw()
Exception in thread "main" java.lang.ClassCastException: typeinfo.E
03.Rhomboid cannot be cast to typeinfo.E03.Circle
        at typeinfo.E03.E03_Rhomboid.main(E03_Rhomboid.java:23)
  */
