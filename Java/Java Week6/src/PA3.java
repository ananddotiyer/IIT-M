import java.util.*;

class PA3_Shop {
    private String name;
    private int nsold; // number of items sold

    public PA3_Shop(String s, int ns) {
        this.name = s;
        this.nsold = ns;
    }

    public String getName() {
        return name;
    }

    public int getItemSold() {
        return nsold;
    }
}

public class PA3 {
    public static void main(String[] args) {
        PA3_Shop s1 = new PA3_Shop("BigBazaar", 20);
        PA3_Shop s2 = new PA3_Shop("BigBazaar", 20);
        PA3_Shop s3 = new PA3_Shop("SV stores", 12);
        PA3_Shop s4 = new PA3_Shop("SunGeneral", 10);
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        m.put(s1.getName(), m.getOrDefault(s1.getName(), 0) + s1.getItemSold());
        m.put(s2.getName(), m.getOrDefault(s2.getName(), 0) + s2.getItemSold());
        m.put(s3.getName(), m.getOrDefault(s3.getName(), 0) + s3.getItemSold());
        m.put(s4.getName(), m.getOrDefault(s4.getName(), 0) + s4.getItemSold());
        String shop = "";
        int sold = 0;
        for (HashMap.Entry<String, Integer> entry : m.entrySet()) {
            if (entry.getValue() > sold) {
                shop = entry.getKey();
                sold = entry.getValue();
            }
        }
        System.out.println(shop + "" + sold);
    }
}