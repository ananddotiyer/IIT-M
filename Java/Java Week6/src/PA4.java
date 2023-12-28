import java.util.*;

class PA4_Student {
    private String name;
    private int maths, physics, chemistry;

    PA4_Student(String s, int m, int p, int c) {
        this.name = s;
        this.maths = m;
        this.physics = p;
        this.chemistry = c;
    }

    public String getName() {
        return name;
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }
}

public class PA4 {
    public static void main(String[] args) {
        PA4_Student s1 = new PA4_Student("Ravi", 90, 55, 50);
        PA4_Student s2 = new PA4_Student("Ram", 72, 80, 55);
        PA4_Student s3 = new PA4_Student("Ramu", 50, 80, 55);
        ArrayList<PA4_Student> l1 = new <PA4_Student>ArrayList();
        ArrayList<PA4_Student> l2 = new <PA4_Student>ArrayList();
        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        for (PA4_Student s : l1) {
            if (s.getMaths() > 80 && s.getPhysics() < 60) {
                l2.add(s);
            }
        }
        System.out.println(l1.size() + " " + l2.size());
    }
}