import java.util.*;

public class Quiz2_161 {
    public static boolean check(Deque<Character> q) {
        while (q.size() > 0)
            if (q.poll() != q.pollLast())
                break;
        return q.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "HANNAH";
        String str2 = "BANANA";
        Deque<Character> queue1 = new ArrayDeque<Character>();
        Deque<Character> queue2 = new ArrayDeque<Character>();
        for (int i = 0; i < 6; i++) {
            queue1.add(str1.charAt(i));
            queue2.add(str2.charAt(i));
        }
        System.out.println(check(queue1));
        System.out.println(check(queue2));
    }
}
