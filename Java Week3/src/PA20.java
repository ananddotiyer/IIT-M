class PA20_A {
    public PA20_A() {
        System.out.println("A() called");
    }
}

class PA20_B extends PA20_A {
    public PA20_B() {
        System.out.println("B() called");
    }
}

class PA20_C extends PA20_B {
    public PA20_C() {
        System.out.println("C() called");
    }
}

public class PA20 {
    public static void main(String[] args) {
        PA20_C oc = new PA20_C();
    }
}