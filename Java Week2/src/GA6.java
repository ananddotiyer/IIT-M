import java.util.*;

class GA6 {
    public static int doSomething(int num) {
        int n = num;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                total = total + i;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int x = doSomething(number);
        System.out.println(x);
    }
}