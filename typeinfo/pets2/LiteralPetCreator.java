package typeinfo.pets2;
import java.util.*;

public class LiteralPetCreator extends PetCreator{
    public static final List<Class<? extends Pet>> allTypes =
		Collections.unmodifiableList(Arrays.asList(Pet.class,Dog.class,
													Cat.class,Rodent.class,
													Mutt.class,Pug.class,
													EgyptianMau.class,Manx.class,
													Cymric.class,Rat.class,
													Mouse.class,Hamster.class));

		//Types for random creation:
		private static final List<Class<? extends Pet>> types =
				allTypes.subList(allTypes.indexOf(Mutt.class),allTypes.size());

		public List<Class<? extends Pet>> types(){
			return types;
		}

		public static void main(String[] args){
			System.out.println(types);
		}
}
/*
java typeinfo.pets.LiteralPetCreator
[class typeinfo.pets.Mutt, class typeinfo.pets.Pug, class typeinfo.pets.EgyptianMau, class typeinfo.pets.Manx, class typeinfo.pets.Cymric, class typeinfo.pets.Rat, class typeinfo.pets.Mouse, class typeinfo.pets.Hamster]

*/
