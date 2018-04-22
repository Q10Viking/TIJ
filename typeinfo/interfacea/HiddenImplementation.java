import typeinfo.interfacea.A;
import typeinfo.packageaccess.*;
import java.lang.reflect.*;

public class HiddenImplementation{
    public static void main(String[] args) throws Exception{
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        /*if( a instanceof C){
            C c = (C)a;
            c.g();
        }*/

        //Oops! Reflection still allows us to call g()
        callHiddenMethod(a,"g");
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }

    static void callHiddenMethod(Object a,String methodName) throws Exception{
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}


/*
java HiddenImplementation
public C.f()
typeinfo.packageaccess.C
public C.g()
package C.u()
protected C.v()
private C.w()
*/
