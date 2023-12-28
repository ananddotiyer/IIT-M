class Mock_Quiz2_3_Person {
    int age;
    String name;

    public Mock_Quiz2_3_Person(String n, int a) {
        age = a;
        name = n;
    }

    public String toString() {
        return (name + ":" + age);
    }
}

class Mock_Quiz2_3_Employee extends Mock_Quiz2_3_Person implements Cloneable {
    public Mock_Quiz2_3_Employee(String n, int a) {
        super(n, a);
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}

public class Mock_Quiz2_3 {
    public static void main(String[] args) {
        Mock_Quiz2_3_Employee[] e1 = { new Mock_Quiz2_3_Employee("Hari", 30), new Mock_Quiz2_3_Employee("geeta", 23) };
        Mock_Quiz2_3_Employee[] e2 = e1.clone();
        e2[1].name = "rani";
        System.out.println(e1[1] + ", " + e2[1]);
    }
}