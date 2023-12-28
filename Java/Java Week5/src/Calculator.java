class Operand<T extends Number> {
    T o1;
    T o2;
}

public class Calculator{
    public static double add(double o1, double o2) {
        return o1 + o2;
    }
    public static void main(String[] args) {
        Operand<Double> x1 = new Operand<Double>();
        x1.o1 = 3.9;
        x1.o2 = 4.3;
        System.out.println(add(x1.o1, x1.o2));
    }
}
