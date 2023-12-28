import java.util.*;

class PA5_Person {
    private String name;
    private int age;

    public PA5_Person(String n, int a) {
        name = n;
        age = a;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println(name + " : " + age);
    }
}

class CompareAge {
    public static int compare(PA5_Person a, PA5_Person b) {
        return b.getAge() - a.getAge();
    }
}

public class PA5 {
    public static void main(String[] args) {
        var list = new ArrayList<PA5_Person>();
        list.add(new PA5_Person("Robin", 33));
        list.add(new PA5_Person("Indra", 76));
        list.add(new PA5_Person("Smita", 35));
        list.add(new PA5_Person("Rikki", 26));
        // Collections.sort(list, (a, b) -> b.getAge() - a.getAge());
        Collections.sort(list, (a, b) -> CompareAge.compare(a, b));
        for (var l : list)
            l.print();
    }
}