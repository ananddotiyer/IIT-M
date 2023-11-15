interface Iterator {
    public boolean has_next();

    public Object get_next();
}

class GA5_NumList<T extends Number> implements Iterator {
    private T[] list;
    private int idx;

    public GA5_NumList(T[] list) {
        this.list = list;
        idx = 0;
    }

    public boolean has_next() {
        if (idx < list.length)
            return true;
        return false;
    }

    public Object get_next() {
        return list[idx++];
    }
}

public class GA5 {
    public static < T extends Number > double sum(GA5_NumList< T > lOb) {
        double total = 0;
        while (lOb.has_next()) {
            total += ((Number) lOb.get_next()).doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Integer[] i_arr = { 10, 20, 30, 40, 59 };
        Double[] d_arr = { 3.44, 2.65, 6.44, 1.3, 6.78 };
        GA5_NumList<Integer> i_list = new GA5_NumList<Integer>(i_arr);
        GA5_NumList<Double> d_list = new GA5_NumList<Double>(d_arr);
        System.out.println(sum(i_list) + ", " + sum(d_list));
    }
}