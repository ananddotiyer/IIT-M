import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapOps {
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("Anand", 0);
        hash.put("Aravind", 1);
        hash.put("Sudha", 2);
        hash.put("Anju", 3);
        
        System.out.println(hash.size());

        System.out.println(hash.get("Sudha"));

        hash.remove("Anju");

        Set<String> keys = hash.keySet();
        System.out.println(keys);

        Collection<Integer> values = hash.values();
        System.out.println(values);

        //Create an iterator on the keys Set, and access the elements.  Iterator can fetch only next element.  No previous.
        System.out.println("Iterate using Iterator operations");
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println("Key: " + key + ", Value: " + hash.get(key));
        }

        //keys is a Set and doesn't provide a listIterator, so it's not possible to iterate keys using listIterator.
        
        //Create an iterator on the entrySet, and access the elements.  Iterator can fetch only next element.  No previous.
        Iterator<Map.Entry<String, Integer>> entries = hash.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<String, Integer> entry = entries.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    
}
