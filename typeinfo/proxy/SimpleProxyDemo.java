package typeinfo.proxy;
import static com.q10viking.util.Print.*;
interface Interface{
	void doSomething();
	void somethingElse(String args);
}

class RealObject implements Interface{
	public void doSomething(){ print("doSomething");}
	public void somethingElse(String args){
		print("somethingElse: "+args);
	}
}

class SimpleProxy  implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxy){
		proxied = proxy;
	}
	public void doSomething(){
		print("SimpleProxy doSomething:");
		proxied.doSomething();
	}
	public void somethingElse(String args){
		print("SimpleProxy somethingElse: "+args);
		proxied.somethingElse(args);
	}
}



public class SimpleProxyDemo{
	static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args){
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}


/*
java typeinfo.proxy.SimpleProxyDemo
doSomething
somethingElse: bonobo
SimpleProxy doSomething:
doSomething
SimpleProxy somethingElse: bonobo
somethingElse: bonobo


*/



