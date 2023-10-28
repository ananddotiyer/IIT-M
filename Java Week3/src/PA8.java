class PA8_Employee {
    private int empid;
    private String name;

    public PA8_Employee(int empid_, String name_) {
        empid = empid_;
        name = name_;
    }

    public PA8_Employee() {
        this(0, "unknown");
    }

    public void print() {
        System.out.print(empid + " : " + name + " : ");
    }
}

class PA8_Manager extends PA8_Employee {
    private String department;

    public PA8_Manager(int empid_, String name_, String department_) {
        department = department_;
    }

    public void print() {
        super.print();
        System.out.println(department);
    }
}

public class PA8 {
    public static void main(String[] args) {
        PA8_Manager m = new PA8_Manager(101, "Nutan", "HR");
        m.print();
    }
}