package typeinfo.pets3;
import typeinfo.pets2.PetCreator;
import typeinfo.factory.Factory;
import java.util.*;
import typeinfo.pets2.Pet;
public class Pets{
    private static class RFPetCreator extends PetCreator{
        static List<Factory<? extends Pet>> petFactories =
            Arrays.asList(new Mutt.Factory(), new Pug.Factory(),
                            new EgyptianMau.Factory(), new Manx.Factory(),
                            new Cymric.Factory(), new Rat.Factory(),
                            new Mouse.Factory(), new Hamster.Factory());

        @Override public List<Class<? extends Pet>> types(){
            return null;
        }
        @Override public Pet randomPet(){
            int n = rand.nextInt(petFactories.size());
            return petFactories.get(n).create();
        }
    }

    private static Random rand = new Random(47);
    public static final PetCreator creator = new RFPetCreator();

    public static Pet randomPet(){
        return creator.randomPet();
    }

    public static Pet[] createArray(int size){
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size);
    }

}
