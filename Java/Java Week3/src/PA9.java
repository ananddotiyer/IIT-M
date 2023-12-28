class PA9_A {
    public float g;

    public PA9_A() {
        g = 9.8f;
    }

    public void show() {
        System.out.println("g = " + g);
    }
}

class PA9_B extends PA9_A {
    public double e;

    public PA9_B(double num) {
        e = num;
    }

    public void show() {
        System.out.println("e = " + e);
    }
}

public class PA9 {
    public static void main(String args[]) {
        PA9_A obj1 = new PA9_B(2.718);

        PA9_A ptr1 = (PA9_A) obj1;
        PA9_A ptr2 = (PA9_B) obj1;
        PA9_B ptr3 = (PA9_B) obj1;

        ptr1.show();
        ptr2.show();
        ptr3.show();
    }
}