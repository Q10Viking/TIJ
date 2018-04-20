package typeinfo.pets3;
import typeinfo.util.TypeCounter;
import static com.q10viking.util.Print.*;
import typeinfo.pets2.Pet;

public class PetCounter5{

    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Pet.class);
        for(Pet pet: Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName()+" ");
            counter.count(pet);
        }
        print();
        print(counter);

    }
}
