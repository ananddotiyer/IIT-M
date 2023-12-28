import java.util.*;

public class Quiz2_162 {
    public static void main(String[] args) {
        List<Integer> runs1 = new ArrayList<>();
        runs1.add(34);
        runs1.add(42);
        runs1.add(50);

        List<Integer> runs2 = new ArrayList<>();
        runs2.add(45);
        runs2.add(90);
        runs2.add(34);

        Map<String, Double> am = new HashMap<>();
        Map<String, List<Integer>> hm = new HashMap<>();
        hm.put("Anil", runs1);
        hm.put("Vikas", runs2);

        Set<String> names = hm.keySet();
        for (String name: names) {
            am.put(name, hm.get(name).stream().mapToInt(i -> i).average().orElse(0));
        }

        System.out.println(am);
    }
}