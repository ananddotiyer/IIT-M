import java.util.*;
import java.util.stream.*;
public class GA6{
       public static void main(String[] args){
            var text = "solutions based on test-and-set are low level and prone to programming errors";
           List<String> words = List.of(text.split(" "));
        //    Thread t = new Thread(() -> words.stream().forEach(System.out::println)); //LINE 1
           Thread t = new Thread(() -> { for(String s : words)
            System.out.println(s);
       });
           t.start();
       }
}