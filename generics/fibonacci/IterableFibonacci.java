package generics.fibonacci;
import java.util.Iterator;
public class IterableFibonacci extends FibonacciGenerator implements Iterable<Integer>{
	private int n;
	public IterableFibonacci(int n){ this.n = n;}	
	public Iterator<Integer> iterator(){
		return new Iterator(){
							public boolean hasNext(){ return n>0;}
							public Integer next(){ 
								n--;
								return IterableFibonacci.this.next();
							}
							public void remove(){
								throw new UnsupportedOperationException();
							}
						};
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		for(Integer i: new IterableFibonacci(18))
			System.out.print(i+" ");
	}
}

/*
java generics.fibonacci.FibonacciGenerator
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*/