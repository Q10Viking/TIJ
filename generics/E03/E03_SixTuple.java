package generics.E03;
import generics.util.SixTuple;

class Amphiban{}
class Vehicle{}

public class E03_SixTuple{
	static SixTuple<Vehicle,Amphiban,String,Float,Double,Byte> a(){
		return new SixTuple<Vehicle,Amphiban,String,Float,Double,Byte>(
							new Vehicle(),new Amphiban(),"hi",(float)4.7,
							1.1,(byte)1);
	}
	public static void main(String[] args){
		System.out.println(a());
	}
}

/*
javac generics.E03.E03_SixTuple
(generics.E03.Vehicle@4e25154f, generics.E03.Amphiban@70dea4e, hi,
4.7, 1.1, 1)
*/
