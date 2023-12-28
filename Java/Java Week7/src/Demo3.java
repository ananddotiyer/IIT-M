import java.util.Scanner;

class NegativeAge extends Exception {
    public NegativeAge(String str){
        super(str);
    }
}
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age <= 0) {
            try {
                throw new NegativeAge("Impossible!");
            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }
        if (age < 18 && age > 0) {
            System.out.println("You are underage!");
        }
    }    
}
