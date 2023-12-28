package Test;
import mathutil.*;

class Calculator extends MathUtility{
    long FibSum(int num, int i){
        long fib = this.getFib(i);
        long sum = this.add(num, fib);
        return sum;
    }
}
public class Test1 extends MathUtility{
    public static void main(String[] args) {
        Calculator c = new Calculator();
        long val = c.add(3, 4);
    }
}
