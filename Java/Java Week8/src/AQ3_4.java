//This is an example of lambda expression used in a higher order function.
interface AQ3_4_X {
    void message();
}

interface AQ3_4_Y extends X {
    void display();
}

public class AQ3_4 {
    public static void main(String arg[]) {
        X ref = () -> {
            System.out.println("Interface X");
        };
        //AQ3_4_Y is not a functional interface, since it has two methods.
        Y ref2 = () -> {
            System.out.println("Interface Y");
        };
        ref.message();
        ref2.display();
    }
}