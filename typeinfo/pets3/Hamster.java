package typeinfo.pets3;
import typeinfo.pets2.Rodent;
public class Hamster extends Rodent {
    public static class Factory
            implements typeinfo.factory.Factory<Hamster> {
        public Hamster create() { return new Hamster(); }
    }
}
