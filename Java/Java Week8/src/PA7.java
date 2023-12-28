import java.util.*;

public class PA7 {
      public static Double merge_func(Double x, Double y) {
            // System.out.printf(x + ", " + y);
            return x + x * y;
      }

      public static void main(String[] args) {
            Map<String, Double> prices = new LinkedHashMap<String, Double>();
            prices.put("Pen", 30.0);
            prices.put("Pencil", 10.0);
            prices.put("Notebook", 40.0);
            prices.put("Paper", 5.0);
            for (Map.Entry<String, Double> e : prices.entrySet()) {
                  //Both below give same output.  Comment one and execute.
                  prices.merge(e.getKey(), 0.1, (x, y) -> x + x * y); //Using lambda
                  // prices.merge(e.getKey(), 0.1, PA7::merge_func); //Using method reference.
            }
            System.out.println(prices);
      }
}