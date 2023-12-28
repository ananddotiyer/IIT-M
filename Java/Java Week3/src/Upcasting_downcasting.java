class Test_A {
    void f() {
        System.out.println("Test_A::f");
    }
}
class Test_B extends Test_A {
    void f() {
        System.out.println("Test_B::f");
    }
}

public class Upcasting_downcasting {
    public static void main(String[] args) {
        Test_A a1 = new Test_A();
        Test_B b1 = new Test_B();
        a1 = b1; //upcasting works always
        a1.f(); //Test_B::f, polymorphism in action.
        
        Test_A a2 = new Test_A();
        Test_B b2 = new Test_B();
        if (a2 instanceof Test_B) {
            //downcasting works only if the
            //object is an instance of subclass.
            b2 = (Test_B)a2;
            System.out.println("a2 is instance of Test_B");
        }
        b2.f(); //Test_B::f
    }
}
