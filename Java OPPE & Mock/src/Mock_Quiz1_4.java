abstract class Mock_Quiz1_4_AbstractOne{
      abstract void myMethod();
}

interface Mock_Quiz1_4_InterfaceOne{
      default void myMethod(){
             System.out.println("Inside Interface Default");
       }
}

// class Child extends AbstractOne implements InterfaceOne{ //WIll give error without implementing myMethod in AbstractOne
class Mock_Quiz1_4_Child implements Mock_Quiz1_4_InterfaceOne{

}
public class Mock_Quiz1_4{
    public static void main(String args[]){
           Mock_Quiz1_4_Child c = new Mock_Quiz1_4_Child();
           c.myMethod();
    }
}