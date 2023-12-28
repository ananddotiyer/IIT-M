class Test_Person{
    public Test_Person(){
        this(2);
        System.out.println("No Arg constructor");
    }
    public Test_Person(int Arg1){
        System.err.println("Constructor with " + Integer.toString(Arg1));
    }
}
public class Test{
    public static void main(String[] args) {
        Test_Person p = new Test_Person(1);
        Test_Person p1 = new Test_Person();
    }
}