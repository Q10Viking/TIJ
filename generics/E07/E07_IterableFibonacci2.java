package generics.E07;
import java.util.Iterator;
import generics.fibonacci.*;

public class E07_IterableFibonacci2 implements Iterable<Integer>{
	private final FibonacciGenerator fb = new FibonacciGenerator();
	private int n=0;
	E07_IterableFibonacci2(int n){this.n = n;}
	public Iterator<Integer> iterator(){
		return new Iterator(){
						public boolean hasNext(){ return n>0;}
						public Integer next(){ 
							n--;
							return fb.next();
						}
						public void remove(){
							throw new UnsupportedOperationException();
						}
					};
	}
	
	public static void main(String[] args){
		for(Integer i: new IterableFibonacci(18))
			System.out.print(i+" ");
	}
}

/*
java generics.E07.E07_IterableFibonacci2
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*/