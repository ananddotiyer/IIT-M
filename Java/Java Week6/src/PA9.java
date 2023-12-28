import java.util.*;

public class PA9 {
    public static void main(String[] args) {
        Map<String, String> map1;
        map1 = new HashMap<String, String>(); // Line 1
        map1.put("India", "Delhi");
        map1.put("Srilanka", "Colombo");
        map1.put("Australia", "Sydney");
        System.out.println(map1); // Line 2
        map1 = new TreeMap<String, String>(map1); // Line 3
        System.out.println(map1); // Line 4
    }
}
