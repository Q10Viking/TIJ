package generics.util;
public class TwoTuple<A,B>{
	public final A first;
	public final B second;
	public TwoTuple(A a,B b){
		first = a;
		second = b;
	}
	
	public String toString(){
		return "("+first+","+second+")";
	}
	public static void main(String[] args){
		TwoTuple<String,Integer> t = new TwoTuple<String,Integer>("Q10Viking",22);
		System.out.println(t);
	}
}

/*
java generics.util.TwoTuple
(Q10Viking,22)

*/