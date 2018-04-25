package generics.E08;
import java.util.Iterator;
import java.util.Random;
import generics.util.Generator;

class StoryCharacter{
	private static long counter=0;
	private final long id = counter++;
	public String toString(){
		return getClass().getSimpleName()+" "+id;
	}
}

class GoodGuy extends StoryCharacter{
	public String toString(){
		return super.toString()+" is a good guy";
	}
}

class BadGuy extends StoryCharacter{
	public String toString(){
		return super.toString()+" is a bad guy";
	}
}


class Morton extends BadGuy{}
class Frank extends BadGuy{}

class Harmonica extends GoodGuy{}
class Cheyenne extends GoodGuy{}


class CharacterGenerator implements Generator<StoryCharacter>,Iterable<StoryCharacter>{
	private Class<?>[] types = {		//Class<? extends StoryCharacter>[]---error!!!
		Morton.class,Frank.class,
		Harmonica.class,Cheyenne.class
	};
	
	private static Random rand = new Random(47);
	private int size;
	public CharacterGenerator(int size){this.size = size;}
	public StoryCharacter next(){
		try{
			return (StoryCharacter)types[rand.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	private class CharacterIterator implements Iterator<StoryCharacter>{
		private int count=size;
		public boolean hasNext(){ return count>0;}
		public StoryCharacter next(){ 
			count--;
			return CharacterGenerator.this.next();
		}
	}
	
	public Iterator<StoryCharacter> iterator(){
		return new CharacterIterator();
	}
	
}

public class E08_CharacterGenerator{
	public static void main(String... args){
		for(StoryCharacter p: new CharacterGenerator(7))
			System.out.println(p);
	}
}

/*
java generics.E08.E08_CharacterGenerator                            
Harmonica 0 is a good guy                                             
Frank 1 is a bad guy                                                  
Harmonica 2 is a good guy                                             
Morton 3 is a bad guy                                                 
Morton 4 is a bad guy                                                 
Harmonica 5 is a good guy                                             
Morton 6 is a bad guy  

*/                                               