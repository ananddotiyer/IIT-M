abstract class Calculator {
    abstract int addition(int a, int b);

    abstract int subtraction(int a, int b);

    abstract int multiplication(int a, int b);

    abstract int division(int a, int b);
}

public class AQ1_1 extends Calculator {
    public int addition(int c, int d) {
        return c + d;
    }

    public int subtraction(int c, int d) {
        return c - d;
    }

    public int division(int c, int d) {
        return c / d;
    }

    public int multiplication(int c, int d) {
        return c * d;
    }

    public static void main(String args[]) {
        AQ1_1 obj = new AQ1_1();
        System.out.println(obj.division(5, 2));
    }
}