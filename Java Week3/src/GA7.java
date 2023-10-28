class Employee {
    private int empid;
    private String name;

    public Employee(int empid_, String name_) {
        empid = empid_;
        name = name_;
    }

    public Employee() {
        this(0, "unknown");
    }

    public void print() {
        System.out.print(empid + " : " + name + " : ");
    }
}

class Manager extends Employee {
    private String department;

    public Manager(int empid_, String name_, String department_) {
        super(empid_, name_); //without this line, it'll print 0 : unknown : HR
        department = department_;
    }

    public void print() {
        super.print();
        System.out.println(department);
    }
}

public class GA7 {
    public static void main(String[] args) {
        Manager m = new Manager(101, "Nutan", "HR");
        m.print();
    }
}