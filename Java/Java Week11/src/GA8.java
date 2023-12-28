import java.util.*;
class GA8_PrlTest extends Thread{
        Map<String, Integer> mp;
        Thread th;
        GA8_PrlTest(Map<String, Integer> ic,Thread t){
             this.mp = ic;
             this.th = t;
        }
        public void run(){
            //If the following section is not commented, the program will go into a deadlock, with this thread waiting for main thread (th.join();) to terminate and with main thread waiting for this thread (t2.join();) to terminate.
            //   try {
            //        th.join();
            //   } catch (InterruptedException ex) {}
              mp.put("D", 4);
       }
}
public class GA8{
      public static void main (String[] args) throws InterruptedException{
            Thread t1 = Thread.currentThread();
            Map<String, Integer> icMap = new LinkedHashMap<String, Integer>();
            String[] str = {"A", "B", "C"};
            Integer[] arr = {1, 2, 3};
            for(int i = 0; i < str.length; i++){
                 icMap.put(str[i], arr[i]);
            }
            GA8_PrlTest t2 = new GA8_PrlTest(icMap, t1);
            t2.start();
            t2.join();
            for(Map.Entry m : icMap.entrySet()){
                   System.out.println(m.getKey() + " => "+ m.getValue());
            }
     }
}