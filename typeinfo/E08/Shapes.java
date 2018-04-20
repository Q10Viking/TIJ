//package typeinfo.E08;
import static com.q10viking.util.Print.*;
import java.util.*;
abstract class Shape{
    void draw(){
        System.out.println(this+".draw()");
    }
    abstract public String toString();
}

class Circle extends Shape{
    public String toString(){
        //return "Circle";
        return this.getClass().getSimpleName();
    }
}

class Square extends Shape{
    public String toString(){
        return this.getClass().getSimpleName();
    }
}

class Triangle extends Shape{
    public String toString(){
        return this.getClass().getSimpleName();
    }
}

class Rhomboid extends Shape{
    public String toString(){
        return "Rhomboid";
    }
}

public class Shapes{
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
            new Circle(),new Square(),new Triangle());
        for(Shape shape: shapeList){
            shape.draw();
        }
    }
}
