class Test_A {

}

class Test_B extends Test_A{

}
public class Test {
    public static void main(String[] args) {
        System.out.println(50/100);
        System.out.println((50f/100));
        Test_A a = new Test_A();
        System.out.println(a instanceof Test_B);
        
        Test_A b = new Test_B();
        System.out.println(b instanceof Test_A);
        System.out.println(b instanceof Test_B);

        Test_A ptr1 = (Test_A)b;
        Test_A ptr2 = (Test_B)b;

        System.out.println(ptr1 instanceof Test_B);
        System.out.println(ptr2 instanceof Test_B);
    }
    
    
}
