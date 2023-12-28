import java.util.stream.Stream;
      import java.util.*;

      public class GA9{
             int j=0;
             public static void main(String []args){
                    ArrayList<Integer> list = new ArrayList<Integer>();

                    for(int i = 1; i< 10; i++){
                          list.add(i);
                    }
                    list.stream().filter(i -> i % 2 == 0)
                    .forEach(s -> System.out.println(s));
             }
      }