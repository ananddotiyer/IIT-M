import java.util.stream.Stream;

public class GA10 {
    public static void main(String[] args) {
        Stream random = Stream.generate(Math::random)
                .map(i -> Math.round(i * 100))
                .filter(j -> j > 50).limit(5);

        random.forEach(s -> System.out.println(s));
    }
}