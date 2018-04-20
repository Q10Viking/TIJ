package typeinfo.pets3;
import typeinfo.pets2.Dog;
public class Mutt extends Dog {
    public static class Factory
        implements typeinfo.factory.Factory<Mutt> {
            public Mutt create() { return new Mutt(); }
        }
}
