 import java.util.stream.*;
     import java.util.*;
   
     public class GA8{
            public static void main(String[] args){
                   int m = 15;
                   Stream.iterate(1, n -> n + 1)
                          .limit(m)
                          .filter(n -> m % n == 0)
                          .forEach(n -> System.out.print(n + " "));

            }
      }