interface AQ2_9_A {
    int a = 10;
}

interface AQ2_9_B {
    int b = 20;
}

class C implements AQ2_9_A, AQ2_9_B {
}

public class AQ2_9 {
    public static void main(String[] args) {
        C oc = new C();
        System.out.println(oc.a);
        System.out.println(oc.b);
    }
}