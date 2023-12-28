import java.util.*;
import java.util.Map.Entry;

class PPA1_RemoveStudent {
    public boolean property(Double value) {
        if (value < 65)
            return true;
        return false;
    }

    public void detained(Map<String, Double> obj) {
        // Iterator<Map.Entry<String, Double>> it = obj.entrySet().iterator();
        // while (it.hasNext()){
        //     Map.Entry<String, Double> e = it.next();
        //     if (property(e.getValue()))
        //         it.remove();
        // }

        Iterator<Map.Entry<String, Double>> entries = obj.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<String, Double> entry = entries.next();
            if (entry.getValue() < 65)
                entries.remove();
        }
        
        // for (Map.Entry<String, Double> e : obj.entrySet()) {
        //     if (property(e.getValue()))
        //         obj.remove(e.getKey());
        // }
        // System.out.println(obj.keySet());
        // for (String e : obj.keySet()) {
        //     if (property(obj.get(e)))
        //         obj.remove(e);
        // }
        display(obj);
    }

    public void display(Map<String, Double> obj) {
        System.out.println(obj);
    }
}

public class PPA1 {
    public static void main(String[] args) {
        Map<String, Double> map = new TreeMap<String, Double>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            map.put(scanner.next(), scanner.nextDouble());
        }
        PPA1_RemoveStudent obj = new PPA1_RemoveStudent();
        obj.detained(map);
        obj.display(map);
    }
}