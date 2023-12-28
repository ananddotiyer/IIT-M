import java.util.*;
class PA7_PrlTest extends Thread{
     Map<String, Integer> icMap;
     public PA7_PrlTest(Map<String, Integer> ic){
          this.icMap = ic;
     }
     public void run(){
          icMap.put("D", 4);
     }
}
public class PA7{
     public static void main (String[] args) throws InterruptedException{
           Thread t1 = Thread.currentThread();
            Map<String, Integer> icMap = new LinkedHashMap<String, Integer>();
            String[] str = {"A", "B", "C"};
            Integer[] arr = {1, 2, 3};
            for(int i = 0; i < str.length; i++){
                 icMap.put(str[i], arr[i]);
            }
            PA7_PrlTest t2 = new PA7_PrlTest(icMap);
            t2.start();
            t2.join();
            for(Map.Entry m : icMap.entrySet()){
                  System.out.println(m.getKey() + " => "+ m.getValue());
            }
      }
}