//This code snippet demonstrates how to use compareTo method of Comparable interface.

import java.util.ArrayList;
import java.util.Collections;

public class Demo1 implements Comparable<Demo1> {
    private String name;

    public Demo1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Demo1 other) {
        return this.name.compareTo(other.getName());
    }

    public static void main(String[] args) {
        Demo1 p1 = new Demo1("Aravind");
        Demo1 p2 = new Demo1("Anand");
        ArrayList<Demo1> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        Collections.sort(persons);
        System.out.println(persons);

        System.out.println(p1.compareTo(p2));
    }
}