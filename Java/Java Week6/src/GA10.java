import java.util.*;

public class GA10 {
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("India", "Delhi");
        map1.put("Srilanka", "Colombo");
        map1.put("Australia", "Sydney");

        Set<String> keys = map1.keySet();
        Collection<String> values = map1.values();

        // This is also fine.
        // Set<String> keys=map1.keySet();
        // Collection<String> values=map1.values();

        Iterator<String> it1 = keys.iterator();
        Iterator<String> it2 = values.iterator();
        System.out.println("Keys are:");
        while (it1.hasNext())
            System.out.println(it1.next());
        System.out.println("values are:");
        while (it2.hasNext())
            System.out.println(it2.next());
    }
}