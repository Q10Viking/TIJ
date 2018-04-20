//package typeinfo.E07;
import static com.q10viking.util.Print.*;

class Candy{
    static {
		print("Loading Candy");
    }
}
class Gum{
	static {
		print("Loading Gum");
	}
}
class Cookie{
	static {
		print("Loading Cookie");
	}
}

public class E07_CommandLoad{
    public static void main(String[] args) throws Exception{
		for(String arg: args)
			Class.forName(arg);
    }
}
/*
java  E07_CommandLoad Candy
Loading Candy
*/