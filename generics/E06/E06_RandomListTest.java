package generics.E06;
import net.mindview.util.*;

public class E06_RandomListTest{
	private static void dump(RandomList<?> rl){
		for(int i=0;i<11;i++){
			System.out.print(rl.select()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		RandomList<String> rs = new RandomList<String>();
		for(String s: ("Hello Q10Viking I love CAU").split(" "))
			rs.add(s);
		dump(rs);
		
		RandomList<Integer> ri = new RandomList<Integer>();
		
		Generator<Integer> gi = new CountingGenerator.Integer();
		for(int i=0;i<11;i++)
			ri.add(gi.next());
		dump(ri);
		
		RandomList<Character> rc = new RandomList<Character>();
		Generator<Character> gc = new CountingGenerator.Character();
		for(int i=0;i<11;i++){
			rc.add(gc.next());
		}
		dump(rc);
	}
}

/*

javac generics.E06.E06_RandomListTest                    
love Hello love Q10Viking Q10Viking CAU love Hello I I love
8 1 9 10 0 0 1 4 5 2 9                                     
i b j k a a b e f c j                                      
*/