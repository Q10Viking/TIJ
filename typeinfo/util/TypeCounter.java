package typeinfo.util;
import java.util.*;

public class TypeCounter extends HashMap<Class<?>,Integer>{
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }

    public void count(Object obj){
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type))
            throw new RuntimeException(obj+" incorrect type: "+
                    type+",should be type or subtype of "+baseType);
        countClass(type);
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type,quantity == null ?1:quantity+1);
        Class<?> superClass = type.getSuperclass();
        //recesive
        if(superClass!= null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair: entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("} ");
        return result.toString();
    }

}

/*
java typeinfo.pets3.PetCounter5
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Rat=2, Rodent=5, Mutt=3, Pug=3, Manx=2, Mouse=2, EgyptianMau=2, Cymric=5, Hamster=1, Manx=5, Dog=6, Cat=9, Pet=20}
*/
