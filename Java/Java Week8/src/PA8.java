import java.util.stream.Stream;

public class PA8{
    public static void main(String[] args) {
        long c = Stream.iterate(0, n -> n + 3).limit(50).count();
        System.out.println(c);

        long c1 = Stream.iterate(0, n -> n + 3).takeWhile(n -> n <= 50).count();
        System.out.println(c1);

        long c2 = Stream.iterate(0, n -> n <= 50, n -> n + 1)
                      .filter(n -> n % 3 == 0).count();
        System.out.println(c2);

        //This will start at n = 50, and continue until n = 100.
        //Modified from the original question.
        long c3 = Stream.iterate(0, n -> n + 3).dropWhile(n -> n < 50).takeWhile(n -> n < 100).count();
        System.out.println(c3);
    }
}