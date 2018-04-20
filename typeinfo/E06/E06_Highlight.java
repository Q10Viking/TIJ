package typeinfo.E06;
import java.util.*;
import java.lang.reflect.*;
class HShape{
	boolean highlighted = false;
	public void highlight(){
		highlighted = true;
	}
	public void clearHighlight(){ highlighted = false;}
	
	void draw(){
		System.out.println(this+" draw()");
	}
	public String toString(){
		return getClass().getName()+(highlighted ? " highlighted":" normal");
	}
	static List<HShape> shapes = new ArrayList<HShape>();
	HShape(){ 
		shapes.add(this);
	}
	static void highlight1(Class<?> type){
		for(HShape shape: shapes)
			if(type.isInstance(shape))
				shape.clearHighlight();
	}
	static void clearHighlight1(Class<?> type) {
		for(HShape shape : shapes)
			if(type.isInstance(shape))
				shape.clearHighlight();
	}
	//Create an applicator and reuse it.All exceptions
	//indicate programmer error, and are thus RuntimeException
	static void forEach(Class<?> type,String method){
		try{
			Method m= HShape.class.getMethod(method,(Class<?>[])null);
			for(HShape shape: shapes){
				if(type.isInstance(shape))
					m.invoke(shape,(Object[])null);
			}
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	static void highlight2(Class<?> type){
		forEach(type,"highlight");
	}
	
	static void clearHighlight2(Class<?> type){
		forEach(type,"clearHighlight");
	}	
}


class HCircle extends HShape{}
class HSquare extends HShape{}
class HTriangle extends HShape{}



public class E06_Highlight{
    public static void main(String[] args){
		List<HShape> shapes = Arrays.asList(
				new HCircle(),new HSquare(),
				new HTriangle(),new HSquare(),
				new HTriangle(),new HSquare(),
				new HCircle(),new HSquare());
				
		HShape.highlight1(HCircle.class);
		HShape.highlight2(HCircle.class);
		for(HShape shape: shapes)
			shape.draw();
		
		System.out.println("----------");
		
		//Highlight them all
		HShape.highlight1(HShape.class);
		HShape.highlight2(HShape.class);
		
		for(HShape shape: shapes){
			shape.draw();
		}
		System.out.println("----------");
		
		//Not in the hierarchy
		HShape.clearHighlight1(ArrayList.class);
		HShape.clearHighlight2(ArrayList.class);
		for(HShape shape: shapes)
			shape.draw();
    }
}


/*
java typeinfo.E06.E06_Highlight           
typeinfo.E06.HCircle highlighted draw()     
typeinfo.E06.HSquare normal draw()          
typeinfo.E06.HTriangle normal draw()        
typeinfo.E06.HSquare normal draw()          
typeinfo.E06.HTriangle normal draw()        
typeinfo.E06.HSquare normal draw()          
typeinfo.E06.HCircle highlighted draw()     
typeinfo.E06.HSquare normal draw()          
----------                                  
typeinfo.E06.HCircle highlighted draw()     
typeinfo.E06.HSquare highlighted draw()     
typeinfo.E06.HTriangle highlighted draw()   
typeinfo.E06.HSquare highlighted draw()     
typeinfo.E06.HTriangle highlighted draw()   
typeinfo.E06.HSquare highlighted draw()     
typeinfo.E06.HCircle highlighted draw()     
typeinfo.E06.HSquare highlighted draw()     
----------                                  
typeinfo.E06.HCircle highlighted draw()     
typeinfo.E06.HSquare highlighted draw()     
typeinfo.E06.HTriangle highlighted draw()   
typeinfo.E06.HSquare highlighted draw()     
typeinfo.E06.HTriangle highlighted draw()   
typeinfo.E06.HSquare highlighted draw()     
typeinfo.E06.HCircle highlighted draw()     
typeinfo.E06.HSquare highlighted draw()  

*/   
/*
We eliminate duplicate code by moving all the methods (starting with toString)
into the base class, and use RTTI to determine the name of the class.
toString( ) also prints whether the object is highlighted.

You must keep track of all objects in a class to highlight or clear all objects of a
particular type. We keep track of shape objects with the static ArrayList
shapes; the HShape default constructor adds the current object to shapes.
We set or clear a boolean flag, using methods in HShape, to change
highlighting on a per-object basis.

The static method highlight1( ) takes an argument of type Class, which is the
type to highlight. It iterates through shapes and calls highlight( ) for each
matched object, testing for a match with Class.isInstance( ).
clearHighlight1( ) works the same way.

Alternatively, we could use reflection in forEach( ) to combine redundant code
that appears in highlight1( ) and clearHighlight1( ) during iteration through
the list. Highlight2( ) and clearHighlight2( ) each call forEach( ).

To call HShape.highlight( ), pass the name of the specific HShape you want
to highlight, with .class appended to produce the Class reference. If you pass
HShape.class as the argument, it matches and highlights every HShape in the
list. Use clearHighlight( ) the same way to clear all highlighting.

If you pass a class that isn¡¯t in the HShape hierarchy, there¡¯s never a match so
the highlight and clearHighlight methods do nothing.
*/