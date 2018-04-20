package typeinfo.E10;
import static com.q10viking.util.Print.*;

public class E10_PrimitiveOrTrue{
    public static void main(String[] args){
		char[] ac = "Hello world".toCharArray();
		print("ac.getClass() "+ac.getClass());
		print("ac.getClass().getSuperclass() "+
			ac.getClass().getSuperclass());
			
		char c = 'c';
		//Can't do it ,primitives are not true objects
		//c.getClass();
		Character cc='c';
		print("cc.getClass() = "+cc.getClass());
		
		int[] ia = new int[3];
		print("ia.getClass() = "+ia.getClass());
		
		long[] la = new long[3];
		print("la.getClass() = "+la.getClass());
		
		double[] da = new double[3];
		print("da.getClass() = "+da.getClass());
		
		String[] sa = new String[3];
		print("sa.getClass() = "+sa.getClass());
		
		E10_PrimitiveOrTrue[] pot = new E10_PrimitiveOrTrue[3];
		print("pot.getClass() = "+pot.getClass());
		
		int[][][] threed = new int[3][][];
		print("threed.getClass() = "+threed.getClass());
		
		
    }
}


/*

java typeinfo.E10.E10_PrimitiveOrTrue                   
ac.getClass() class [C                                    
ac.getClass().getSuperclass() class java.lang.Object      
cc.getClass() = class java.lang.Character                 
ia.getClass() = class [I                                  
la.getClass() = class [J                                  
da.getClass() = class [D                                  
sa.getClass() = class [Ljava.lang.String;                 
pot.getClass() = class [Ltypeinfo.E10.E10_PrimitiveOrTrue;
threed.getClass() = class [[[I                            

*/









