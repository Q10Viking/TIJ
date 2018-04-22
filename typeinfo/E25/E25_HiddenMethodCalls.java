import java.lang.reflect.*;
import typeinfo.E25.classa.A;


public class E25_HiddenMethodCalls{
    static void callHiddenMethod(Object type,String name) throws Exception{
        Method method = type.getClass().getDeclaredMethod(name);
        method.setAccessible(true);
        method.invoke(type);
    }

    public static void main(String[] args) throws Exception{
        class B extends A{
            public void b(){super.b();}
        }

        A a = new A();
       // a.b();
        callHiddenMethod(a,"a");
        callHiddenMethod(a,"b");
        callHiddenMethod(a,"c");

        B b = new B();
        b.b();

    }
}

/*
java E25_HiddenMethodCalls
private A.a()
protected A.b()
package A.c()
protected A.b()
*/
