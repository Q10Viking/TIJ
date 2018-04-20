package typeinfo.pets3;
import typeinfo.pets2.Rodent;
public class Rat extends Rodent {
    public static class Factory
        implements typeinfo.factory.Factory<Rat> {
            public Rat create() { return new Rat(); }
    }
}
