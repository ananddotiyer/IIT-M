import java.util.*;

public class PA6 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("IITM");
        list1.add("Java");
        list1.add("Java");
        list1.add("Programming");

        Set<String> set1 = new HashSet<String>(list1);// Line 1
        for (String string : set1) {
            System.out.println(string);
        }
    }
}