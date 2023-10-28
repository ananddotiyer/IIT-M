class AQ2_9_A {
    int a = 10;
    int b = 20;
}

class AQ2_9_B extends AQ2_9_A {
}

public class AQ2_9 {
    public static void main(String[] args) {
        AQ2_9_B ob = new AQ2_9_B();
        AQ2_9_A oa = new AQ2_9_A();
        ob.a = 20;
        System.out.println(oa.a);
        System.out.println(ob.a);
    }
}