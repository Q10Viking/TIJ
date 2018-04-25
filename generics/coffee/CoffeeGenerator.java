package generics.coffee;
import generics.util.Generator;
import java.util.*;
public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
	private Class[] types = {Latte.class,Mocha.class,
								Cappuccino.class,Americano.class,Breve.class,};
	private static Random rand = new Random(47);
	private int size = 0;
	public CoffeeGenerator(){}
	public CoffeeGenerator(int size){this.size = size;}
	
	public Coffee next(){
		try{
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		int count = size;
		public boolean hasNext(){
			return count>0;
		}
		public Coffee next(){
			count--;
			return CoffeeGenerator.this.next();
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<Coffee> iterator(){
		return new CoffeeIterator();
	}
	public static void main(String[] args){
		for(Coffee c: new CoffeeGenerator(5))
			System.out.print(c+" ");
	}
}



/*

java generics.coffee.CoffeeGenerator
Americano 0 Latte 1 Americano 2 Mocha 3 Mocha 4

*/