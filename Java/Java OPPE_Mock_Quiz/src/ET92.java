import java.util.*;
import java.util.concurrent.*;

public class ET92 extends Thread{
    static Map<Integer, Integer> mp = new LinkedHashMap<>();

    public void run() {
        Integer[] prime_no = {3,5,7,11,13,17,19,23};
        for (int i = 0; i < prime_no.length; i++) {
            mp.put(i + 2, prime_no[i]);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        mp.put(1,2);
        ET92 t = new ET92();
        t.start();
        for (Object o: mp.entrySet()) {
            // System.out.println("Entry set is : \n " + mp.entrySet());
            System.out.println(o);
            Thread.sleep(100);
        }
    }
}