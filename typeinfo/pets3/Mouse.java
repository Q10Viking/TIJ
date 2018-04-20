package typeinfo.pets3;
import typeinfo.pets2.Rodent;
public class Mouse extends Rodent {
    public static class Factory
        implements typeinfo.factory.Factory<Mouse> {
            public Mouse create() { return new Mouse(); }
    }
}
