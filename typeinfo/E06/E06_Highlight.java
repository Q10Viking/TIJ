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