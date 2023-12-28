  import java.util.stream.Stream;
  import java.util.*;
  import java.util.stream.Collectors;
 
  public class PA10 {
         public static void main(String[] args) {
               //CODE BLOCK begins here
               Stream<Integer> integers = Stream.iterate(0, i -> i < 50, i -> i+1);
               integers.map(i -> i % 7 == 0).forEach(System.out::println);
               //CODE BLOCK ends here
         }
   }