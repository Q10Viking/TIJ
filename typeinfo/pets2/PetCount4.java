package typeinfo.pets2;
import typeinfo.util.TypeCounter;

public class PetCount4{
    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Pet.class);
        for(Pet pet: Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName()+" ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}

/*
java typeinfo.pets2.PetCount4
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hams
ter EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Rat=2, Rodent=5, Mutt=3, Dog=6, EgyptianMau=2, Pug=3, Cat=9, Manx=7
, Hamster=1, Cymric=5, Pet=20, Mouse=2,

*/
