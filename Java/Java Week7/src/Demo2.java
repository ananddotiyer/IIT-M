import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) {
        try {
            try {
                try {
                    try {
                        int i = 1/0;
                    } catch (ArithmeticException e4) {
                        IOException ex4 = new IOException("This is the innermost");
                        ex4.initCause(e4);
                        throw ex4;
                    }
                } catch (IOException e3) {
                    IOException ex3 = new IOException("This is the second level");
                    ex3.initCause(e3);
                    throw ex3;
                }
            } catch (IOException e2) {
                IOException ex2 = new IOException("This is an IOException");
                ex2.initCause(e2);
                throw ex2;
            }
        } catch (IOException e1) {
            System.out.println(e1.getMessage());
            System.out.println(e1.getCause().getMessage());
            System.out.println(e1.getCause().getCause().getMessage());
        }
        
    }
}
