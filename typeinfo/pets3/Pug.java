package typeinfo.pets3;
import typeinfo.pets2.Dog;
public class Pug extends Dog {
    public static class Factory
        implements typeinfo.factory.Factory<Pug> {
             public Pug create() { return new Pug(); }
    }
}
