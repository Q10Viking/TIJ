interface base{}

class Imp implements base{
    public String toString(){
        return "Imp";
    }
}

public class TestM2{
    public static void main(String[] args){
        base p = new Imp();
        System.out.println(p);
    }
}
