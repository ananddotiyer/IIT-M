// This demonstrates the use of wild-cards.

import java.util.*;

class Demo2_Pair<T extends Number> {
    T key;
    T value;

    public Demo2_Pair(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public void addPair(Demo2_Pair<?> p) {
        System.out.printf("(%f, %f)", p.key.doubleValue() + key.doubleValue(), p.value.doubleValue() + value.doubleValue());
    }
}

public class Demo2 {
    public static void main(String[] args) {
        Demo2_Pair<Integer> p1 = new Demo2_Pair<Integer>(12, 14);
        Demo2_Pair<Double> p2 = new Demo2_Pair<Double>(20.2, 14.3);
        p1.addPair(p2);
    }
}