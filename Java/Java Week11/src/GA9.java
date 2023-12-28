import java.util.*;
import java.util.concurrent.*;
class GA9_Example extends Thread{
       Map siMap;
       GA9_Example(Map m){
               this.siMap = m;
        }
        public void run(){
               siMap.put("D",4);
        }
}
public class GA9{
      public static void main (String[] args) {
            Map<String, Integer> siMap = new ConcurrentHashMap();
            String[] str = {"A", "B", "C"};
            Integer[] arr = {1, 2, 3};
            for(int i = 0; i < str.length; i++){
                    siMap.put(str[i],arr[i]);
            }
           GA9_Example t = new GA9_Example(siMap);
            t.start();
           Set s = siMap.entrySet();
           Iterator itr = s.iterator();
           while(itr.hasNext()){
                  Map.Entry m = (Map.Entry)itr.next();
                  System.out.println(m.getKey() + " => " + m.getValue());
            }
     }
}