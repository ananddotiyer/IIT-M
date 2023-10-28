interface Iterator {
    public boolean has_next();

    public Object get_next();
}

class NumList<T extends Number> implements Iterator {
    private T[] list;
    private int idx;

    public NumList(T[] list) {
        this.list = list;
        idx = 0;
    }

    public boolean has_next() {
        if (idx < list.length - 1)
            return true;
        return false;
    }

    public Object get_next() {
        idx++;
        return list[idx];
    }
}

public class GA5 {
    public static < T extends Number > double sum(NumList< T > lOb) {
        double total = 0;
        while (lOb.has_next()) {
            total += ((Number) lOb.get_next()).doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Integer[] i_arr = { 10, 20, 30, 40, 59 };
        Double[] d_arr = { 3.44, 2.65, 6.44, 1.3, 6.78 };
        NumList<Integer> i_list = new NumList<Integer>(i_arr);
        NumList<Double> d_list = new NumList<Double>(d_arr);
        System.out.println(sum(i_list) + ", " + sum(d_list));
    }
}