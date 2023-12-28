import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Week5");
        int x = 12;
        Integer my_x = x; //Auto-boxing.  Create an integer object.
        int y = my_x; //Auto-unboxing.  Convert integer object to int primitive.

        Method[] methods = my_x.getClass().getDeclaredMethods();
        for (Method i : methods) {
            System.out.println(i);
        }

        System.out.printf("int: %d Boxed Integer: %d Unboxed int: %d", x, my_x, y);
    }
}
