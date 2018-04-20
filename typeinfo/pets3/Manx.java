package typeinfo.pets3;
import typeinfo.pets2.Cat;
public class Manx extends Cat {
public static class Factory
    implements typeinfo.factory.Factory<Manx> {
        public Manx create() { return new Manx(); }
    }
} ///:~
