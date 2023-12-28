import java.util.*;
import java.util.stream.*;

public class Quiz2_174 {
    public static void main(String[] args) {
        double c = Stream.iterate(1, n -> n + 1)
                .map(n -> n * n * n)
                .limit(5)
                .count();
        //Same as above
        double c1 = Stream.iterate(1, n -> n <= 5, n -> n + 1)
                .map(n -> n * n * n)
                .limit(5)
                .count();

        System.out.println(c);
        System.out.println(c1);
    }
}
