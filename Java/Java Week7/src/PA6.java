public class PA6 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        String name = "IIT madras java";
        int index = scanner.nextInt();
        try {
            c = a / b;
            System.out.println("Quotient is " + c);
            System.out.println(name.charAt(index));
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}