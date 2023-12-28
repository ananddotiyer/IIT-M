import java.util.*;

public class PA5 {
    public static void main(String args[]) {
        LinkedList<String> obj = new LinkedList<String>();
        obj.add("A");
        obj.add("C");
        obj.add(0, "D");
        obj.add("B");
        Collections.sort(obj);
        System.out.println(obj);
    }
}