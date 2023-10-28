class A_3_1 {
    public void fun() {
        System.out.println("Inside A's fun");
    }
    public static void stat() {
        System.out.println("Inside A's static");
    }
    public void poly() {
        System.out.println("Poly in A");
    }
}

class B extends A_3_1 {
    public void fun() {
        System.out.println("Inside B's fun");
    }
    public static void stat() {
        System.out.println("Inside B's static");
    }
    public void poly() {
        System.out.println("Inside B's poly");
    }
    public void only_in_child() {
        System.out.println("Inside B's only_in_child");
    }
}
public class Week3 {
    public static void main(String[] args) {
        System.out.println("Inside main");
        
        A_3_1 a = new A_3_1();
        a.fun();
        a.poly();
        
        //Static method "poly"
        B b = new B();
        b.fun();
        b.poly();
        b.only_in_child();
        
        //Dynamic dispatch of method "poly"
        A_3_1 a1 = new B();
        a1.fun(); //This should call B's fun
        a1.poly();
        // a1.only_in_child(); //This gives error
        
        // But explicitly casting it to B works.
        if (a1 instanceof B)
            ((B) a1).only_in_child(); 

        //static method call is for a specific class.
        A_3_1.stat();
        B.stat();
    }
}
