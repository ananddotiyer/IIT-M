package pack1;

public class Test {
    public static void main(String[] args) {
        Calculator c1 = new SmartCalculator();
        System.out.println(c1.div(10, 2));
        System.out.println(c1.timeit()); //timeit is not available in Calculator class.
        System.out.println(c1.sum(10, 20));
        System.out.println(c1.diff(10, 20)); //diff is private method in Calculator.
    }
}
