package typeinfo.util;
import java.util.*;


public class Staff extends ArrayList<Position>{
    public void add(String title,Person person){
        add(new Position(title,person));
    }

    public void add(String... titles){
        for(String title: titles)
            add(new Position(title));
    }

    public Staff(String... titles){add(titles);}

    public boolean positionAvailable(String title){
        for(Position position: this)
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL)
                return true;
        return false;
    }

    public void fillPosition(String title,Person hire){
        for(Position position: this)
            if(position.getTitle().equals(title)&&
                    position.getPerson()==Person.NULL){
                position.setPerson(hire);
            return;
            }
        throw new RuntimeException("position "+title+" not avaliable");
    }

    public static void main(String[] args){
        Staff staff = new Staff("President","CTO","Marketing Manager",
                                "Product Manager","Project Leader","Software Engineer",
                                "Software Engineer","Software Engineer","Software Engineer",
                                "Technical Writer","Test Engineer");
        staff.fillPosition("President",new Person("Me","Last","The top,Lonely At"));
        staff.fillPosition("Project Leader",new Person("Janet","Planner","The Burbs"));
        if(staff.positionAvailable("Software Engineer"))
            staff.fillPosition("Software Engineer",new Person("Bob","Coder","Bright Light City"));
        System.out.println(staff);
    }
}

/*

java typeinfo.util.Staff
[Postion: President Person: Me Last The top,Lonely At, Postion: CTO
 NullPerson, Postion: Marketing Manager NullPerson, Postion: Produc
t Manager NullPerson, Postion: Project Leader Person: Janet Planner
 The Burbs, Postion: Software Engineer Person: Bob Coder Bright Lig
ht City, Postion: Software Engineer NullPerson, Postion: Software E
ngineer NullPerson, Postion: Software Engineer NullPerson, Postion:
 Technical Writer NullPerson, Postion: Test Engineer NullPerson]

 */
