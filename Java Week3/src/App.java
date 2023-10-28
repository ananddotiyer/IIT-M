import java.util.Scanner;

class Demo1 {
    private void demo1() {
        System.out.println("Inside demo1");
    }
    final void demo2() {
        System.out.println("Inside demo2");
    }
    public void demo3() {
        System.out.println("Inside demo3");
    }
}

class Demo1_Inherited extends Demo1 {
    //private method in parent cannot be overridden.  It can't even be accessed.
    public void demo1() {
        System.out.println("Inside inherited demo1");
    }
    
    //final method in parent cannot be overridden.
    // public void demo2() {
    //     System.out.println("Inside inherited demo2");
    // }
    
    //Access specifier can't be reduced.  public->default isn't allowed.
    // void demo3() {
    //     System.out.println("Inside inherited demo3");
    // }
}
public class App {
    public static void main(String[] args) throws Exception {
        Demo1 d = new Demo1();
        // d.demo1();
        Demo1_Inherited d_1 = new Demo1_Inherited();
        d_1.demo1();
        d_1.demo2();
    }
}
