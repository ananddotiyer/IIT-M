import java.util.stream.Stream;
import java.util.*;

public class PA9 {
    public static void main(String[] args) {
        Map<Integer, String> student_map = new TreeMap<Integer, String>();
        student_map.put(80, "Arya");
        student_map.put(62, "Diya");
        student_map.put(71, "Fiona");
        student_map.put(79, "Mason");
        student_map.put(90, "Maria");
        Stream<Map.Entry<Integer, String>> scores = student_map.entrySet().stream().limit(3);

        System.out.println(Arrays.toString(scores.toArray()));
    }
}