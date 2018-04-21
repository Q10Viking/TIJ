class Base{}
interface Interface{}


class TestM1 extends Base implements Interface{
    public static void main(String[] args){
        System.out.println("Hello world");
    }
}

/* //error!!!
class TestM1 implements Interface extends Base{
    public static void main(String[] args){
        System.out.println("Hello world");
    }
}
*/
