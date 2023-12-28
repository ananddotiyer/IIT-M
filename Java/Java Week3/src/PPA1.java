import java.util.*;
    class PPA1_Calculator{
        public void sum(double a, double b) {
            System.out.println(a + b);
        }
        public void subtraction(double a, double b) {
            System.out.println(a - b);
        }
        public void multiply(double a, double b) {
            System.out.println(a * b);
        }
        public void division(double a, double b) {
            System.out.println(a / b);
        }
   }
   class PPA1_UpdatedCalculator extends PPA1_Calculator{
        public void remainder(double a, double b) {
            System.out.println(a % b);
        }
} 
    public class PPA1{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double n1 = sc.nextDouble();
            double n2 = sc.nextDouble();
            PPA1_Calculator c = new PPA1_Calculator();
            c.sum(n1, n2);
            c.subtraction(n1, n2);
            c.multiply(n1, n2);
            c.division(n1, n2);
            PPA1_UpdatedCalculator uc = new PPA1_UpdatedCalculator();
            uc.remainder(n1, n2);
        }
    
    }