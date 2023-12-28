public class PA3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            assert b != 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("in catch block");
        } finally {
            System.out.println("in finally block");
        }
        System.out.println("end of main()");
    }
}