public class GA3{
      public static double compute(int a, int b){
            int c = 0;
            assert a > 0: "a must be > 0"; //assert-1
            assert b > 0: b; //assert-2
            c = a / b;
            assert c >= 0: c; //assert-3
            return Math.sqrt(c);
      }
      public static void main(String[] args){
            int a = 10;
            int b = -5;
            assert b != 0: "b == 0"; //assert-4
            compute(a, b);
      }
}