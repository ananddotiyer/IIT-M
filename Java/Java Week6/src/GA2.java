import java.util.*;

public class GA2 {
    public static void main(String[] args) {
        Map<Character, Integer> frequencyTab = new LinkedHashMap<Character, Integer>();
        String str = "incomprehensibilities";
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            frequencyTab.put(c, frequencyTab.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : frequencyTab.entrySet()) {
            System.out.print("[" + e.getKey() + ", " + e.getValue() + "] ");
        }
    }
}