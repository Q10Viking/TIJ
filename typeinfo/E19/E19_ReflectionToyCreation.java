import java.lang.reflect.*;
class SuperToy extends FancyToy{
	int IQ;
	public SuperToy(int intelligence){
		IQ = intelligence;
	}
	public String toString(){
		return "I'm a SuperToy,I'm smarter than you.IQ: "+IQ;
	}
}


public class E19_ReflectionToyCreation{
	public static Toy makeToy(String toyName,int IQ){
		try{
			Class<?> tClass = Class.forName(toyName);
			for(Constructor<?> ctor: tClass.getConstructors()){
				//Look for a constructor with a single parameter
				Class<?> [] params = ctor.getParameterTypes();
				if(params.length == 1){
					if(params[0] == int.class)
						return (Toy)ctor.newInstance(new Object[]{Integer.valueOf(IQ)});
				}
			}
		}catch(ClassNotFoundException e){
			System.out.println("No such Class: "+toyName);
		}catch(InstantiationException ex){
			throw new RuntimeException(ex);
		}catch(IllegalAccessException ex){
			throw new RuntimeException(ex);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(makeToy("SuperToy",150));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}