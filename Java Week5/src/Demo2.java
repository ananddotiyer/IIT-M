// This demonstrates the use of wild-cards.

import java.util.*;

class Pair<T extends Number> {
    T key;
    T value;

    public Pair(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public void addPair(Pair<?> p) {
        System.out.printf("(%f, %f)", p.key.doubleValue() + key.doubleValue(), p.value.doubleValue() + value.doubleValue());
    }
}

class Main {
    public static void main(String[] args) {
        Pair<Integer> p1 = new Pair<Integer>(12, 14);
        Pair<Double> p2 = new Pair<Double>(20.2, 14.3);
        p1.addPair(p2);
    }
}