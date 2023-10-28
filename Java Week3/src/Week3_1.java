class Employee_3_1 {
    String name;
    double salary;
    public Employee_3_1 (String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public void display(){
        System.out.println(name);
        System.out.println(salary);
    }
}

class Manager_3_1 extends Employee_3_1 {
    public Manager_3_1(String name, double salary) {
        super(name, salary);
    }

    public void display() {
        System.out.println(salary);
        System.out.println(name);
    }
}

public class Week3_1 {
    public static void main(String[] args) {
        System.out.println("Inside main");
        //static
        Employee_3_1 e = new Employee_3_1("Anand", 10000.00);
        e.display();

        //dynamic dispatch.
        Employee_3_1 m = new Manager_3_1("Aravind", 1000000.00);
        m.display();
    }
}
