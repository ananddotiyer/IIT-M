class AQ2_6_Repository<T1, T2> {
    T1 item1;
    T2 item2;

    AQ2_6_Repository(T1 x, T2 y) {
        this.item1 = x;
        this.item2 = y;
    }

    public T1 getItem1() {
        return item1;
    }

    public T2 getItem2() {
        return item2;
    }
}

public class AQ2_6 {
    public static void main(String args[]) {
        // Question actually uses double instead of Double, and causes compilation error.
        AQ2_6_Repository<String, Double> obj = new AQ2_6_Repository<String, Double>("ABC", 5.5);
        System.out.println(obj.getItem1() + "\n" + obj.getItem2());
    }
}