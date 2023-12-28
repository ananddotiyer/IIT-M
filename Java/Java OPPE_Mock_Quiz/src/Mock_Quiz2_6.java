import java.util.*;

public class Mock_Quiz2_6 {
    public static void main(String[] args) {
        Map<Set<String>, List<String>> m = new HashMap<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("30");
        list1.add("40");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("35");
        list2.add("45");

        Set<String> set1 = new HashSet<>();
        set1.add("ravi");
        set1.add("ravi");
        m.put(set1, list1);
        m.put(set1, list2);
        System.out.println(m);
    }
}