class PA7_A {
    public void show() throws Exception {
        System.out.println("Super class show with Exception");
    }
}

class PA7_B extends PA7_A {
    public void show() throws RuntimeException {
        System.out.println("Sub class show with RuntimeException");
    }
}

public class PA7 {
    public static void main(String[] args) throws Exception {
        PA7_B ob = new PA7_B();
        ob.show();

        PA7_A oa = new PA7_A();
        oa.show();
    }
}