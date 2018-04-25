package generics.fibonacci;
import generics.util.*;
public class FibonacciGenerator implements Generator<Integer>{
	private int count;

	public Integer next(){
		return fibOP(count++);
		//return fib(count++);
	}
	int a=1,b=1;
	private Integer fibOP(int n){
		if(n<2)
			return 1;
		int result=b+a;
		a = b;b=result;
		return result;
		
	}
	private Integer fib(int n){
		if(n<2)
			return 1;
		return fib(n-2)+fib(n-1);
	}

	public static void main(String[] args){
		FibonacciGenerator gen = new FibonacciGenerator();
		for(int i=0;i<18;i++)
			System.out.print(gen.next()+" ");
		
		//System.out.println(Integer.MAX_VALUE);
	}
}
/*
java generics.fibonacci.FibonacciGenerator
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*/