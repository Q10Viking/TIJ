import java.util.*;

class Snow{}
class Powder extends Snow{}
class Crusty extends Snow{}
class Slush extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}


public class AsListInference{
    public static void main(String[] args){
        List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
        List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
    }
}
