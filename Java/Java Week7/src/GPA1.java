import java.util.*;
//Define DivisionException class here
class DivisionException extends Exception {
    // @Override
    // public String toString() {
    //     return "Division by 3 is not allowed";
    // }
    public DivisionException(String msg) {
        super(msg);
    }
}
public class GPA1 {
 
    //Define divide(int a, int b) here
    static int divide(int a, int b) throws DivisionException {
        if (b == 3) {
            throw new DivisionException("Division by 3 is not allowed");
        }
        return a / b;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int x = sc.nextInt();
       int y = sc.nextInt();
       
       try {
           System.out.println(divide(x, y));
       } catch (DivisionException e) {
            System.out.println(e.toString());
        }


   }
} 