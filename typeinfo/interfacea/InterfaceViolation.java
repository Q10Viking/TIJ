import typeinfo.interfacea.A;
class B implements A{
    public void f(){ System.out.println("func f");}
    public void g(){ System.out.println("func g");}
}


public class InterfaceViolation{
    public static void main(String[] args){
        A a = new B();
        a.f();
        //a.g();
        System.out.println(a.getClass().getName());
        if(a instanceof B){
            B b = (B)a;
            b.g();
        }
    }
}


/*
java InterfaceViolation
func f
B
func g
*/
