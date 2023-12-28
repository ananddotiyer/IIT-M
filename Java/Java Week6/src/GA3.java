import java.util.*;

public class GA3 {
    public static void main(String[] args) {
        Map<Integer, Character> entries = new TreeMap<Integer, Character>();
        entries.put(30, 'b');
        entries.put(40, 'a');
        entries.put(20, 'd');
        entries.put(10, 'c');

        TreeSet<Character> values = new TreeSet<Character>(entries.values()); //a b c d
        // LinkedList<Character> values = new LinkedList<Character>(entries.values()); //c d b a
        // Collection <Character> values = entries.values(); //c d b a
        // PriorityQueue<Character> values = new PriorityQueue<Character>(entries.values()); // a c b d
        for (Character c : values)
            System.out.print(c + " ");
    }
}