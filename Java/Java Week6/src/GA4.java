import java.util.*;

public class GA4 {
      public static void main(String args[]) {
            ArrayList<String> sList = new ArrayList<String>();
            sList.add("A");
            sList.add("B");
            ListIterator<String> iter = sList.listIterator();
            if (iter.hasNext()) {
                  iter.next();
                  iter.add("C");
            }
            if (iter.hasPrevious()) {
                  iter.previous();
                  iter.add("D");
            }
            sList.add("E");
            System.out.println(sList);
      }
}