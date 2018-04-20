package typeinfo.pets3;
import typeinfo.pets2.Cat;
public class EgyptianMau extends Cat{
    public static class Factory implements typeinfo.factory.Factory<EgyptianMau>{
        public EgyptianMau create(){ return new EgyptianMau();}
    }
}
