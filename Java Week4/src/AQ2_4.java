class Fibo {
      int fibonacci(int x) {
            int a = 0, b = 1, c = 0;
            for (int i = 1; i <= x - 2; i++) {
                  c = a + b;
                  a = b;
                  b = c;
            }
            return c;
      }
}

interface Statement {
      abstract String display();
}

public class AQ2_4 extends Fibo implements Statement {
      public String display() {
            return "The required fibonacci number is:";
      }

      public static void main(String args[]) {
            System.out.println(new AQ2_4().display() + " " + new Fibo().fibonacci(7));
      }
}