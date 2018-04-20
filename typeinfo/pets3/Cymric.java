package typeinfo.pets3;
import typeinfo.pets2.Manx;
public class Cymric extends Manx{
    public static class Factory implements typeinfo.factory.Factory<Cymric>{
        public Cymric create(){ return new Cymric();}
    }
}
