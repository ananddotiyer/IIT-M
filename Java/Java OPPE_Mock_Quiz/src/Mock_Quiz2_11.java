public class Mock_Quiz2_11 {
    String msg = null;

    public void show() {
        try {
            try {
                System.out.println(10 / 0);
            } catch (ArithmeticException e) {
                msg = e.getMessage(); // Line 1
            }
            try {
                System.out.println("IITM".charAt(5));
            } catch (StringIndexOutOfBoundsException e) {
                msg = e.getMessage(); // Line 2
            }
        } finally {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Mock_Quiz2_11 obj = new Mock_Quiz2_11();
        obj.show();
    }
}