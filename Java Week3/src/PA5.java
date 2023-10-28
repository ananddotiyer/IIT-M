class PA5_Parent {
    public void f1() {
        System.out.println("f1() called from parent class");
    }
}

class PA5_Child extends PA5_Parent {
    public void f1() {
        System.out.println("f1() called from child class");
    }
}

public class PA5 {
    public static void main(String[] args) {
        // LINE 1
        new PA5_Parent().f1();

        PA5_Child p = new PA5_Child();
        p.f1();
        ((PA5_Child)p).f1();

        ((PA5_Parent)new PA5_Child()).f1();
    }
}