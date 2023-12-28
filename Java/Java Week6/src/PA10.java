    import java.util.*;
    public class PA10{
          public static void main (String[] args){
                  Map<String, Integer> map = new LinkedHashMap<String, Integer>();
                  String[] str = {"E","A","B","D","C"};
                  Integer[] arr = {5,3,1,2,4};
                  for(int i=0;i<str.length;i++){
                      map.put(str[i],arr[i]);
                  }
                 Set s=map.entrySet();
                 Iterator itr=s.iterator();
                 while(itr.hasNext()){
                     Map.Entry m = (Map.Entry)itr.next();
                     if(m.getKey().equals("B")){
                           m.setValue(2);
                     }
                     System.out.println(m.getKey()+" => "+m.getValue());
                 }
          }
    }