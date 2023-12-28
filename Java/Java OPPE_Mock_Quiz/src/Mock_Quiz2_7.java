import java.util.*;
import java.util.stream.*;

public class Mock_Quiz2_7 {
    public static void main(String[] args) {
        Optional<Double> d = Stream.generate(Math::random)
                .limit(100)
                .map((i) -> i + 10)
                .max(Double::compareTo);

        System.out.println(d);
    }
}