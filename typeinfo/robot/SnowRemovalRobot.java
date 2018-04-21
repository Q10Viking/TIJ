package typeinfo.robot;
import java.util.*;


public class SnowRemovalRobot implements Robot{
    private String name;
    public SnowRemovalRobot(String name){ this.name=name;}
    public String name(){ return name;}
    public String model(){ return "SnowBot Series 11";}
    public List<Operation> operations(){
        return Arrays.asList(
                new Operation(){
                    public String description(){
                        return name+" can shovel snow";
                    }
                    public void command(){
                        System.out.println(name+" shoveling snow");
                    }
                },
                new Operation(){
                    public String description(){
                        return name+" can chip ice";
                    }
                    public void command(){
                        System.out.println(name+" chipping ice");
                    }
                },
                new Operation(){
                    public String description(){
                        return name+" can clear the roof";
                    }
                    public void command(){
                        System.out.println(name+" clearing roof");
                    }
                });
    }

    public static void main(String[] args){
        Robot.Test.test(new SnowRemovalRobot("Q10Viking"));
    }

}


/*

java typeinfo.robot.SnowRemovalRobot
Robot name: Q10Viking
Robot model: SnowBot Series 11
Q10Viking can shovel snow
Q10Viking shoveling snow
Q10Viking can chip ice
Q10Viking chipping ice
Q10Viking can clear the roof
Q10Viking clearing roof

  */
