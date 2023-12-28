import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // boolean flag = 1;
        boolean flag = true;


        int a = 10;
        System.out.println(String.valueOf(a) + ", "+ String.valueOf(a));
        System.out.println("Addition of 10 and 20 is " + (10 + 20));

        int[] c = {1, 2, 3};
        int[] d = c;
        System.out.print(c == d);

        int i1 = 10, i2 = 29;
        double e;
        e = i1 / i2 * i2;
        System.out.print(e + " ");
        e = i2 * i1 / i2;
        System.out.print(e + " ");

        String[] State1 = {"Chennai", "Kolkata", "Tripura" };
        System.out.println(State1.length);
        
        String[] State2 = new String[] {"Chennai", "Kolkata", "Tripura" };
        System.out.print(State2[0] + " ");
    }
    public static void calculate() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j * j;
            }
        }

        System.out.println(sum);
    }
}
