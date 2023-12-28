import java.util.*;

interface Employee {
    public abstract void showSalary();
}

class Manager implements Mock_Quiz2_3_Employee {
    double salary;

    public Manager(double amt) {
        salary = amt;
    }

    public void showSalary() {
        System.out.println("Manager salary: " + salary);
    }
}

class HiringManager implements Mock_Quiz2_3_Employee {
    double salary;

    public HiringManager(double amt) {
        salary = amt;
    }

    public void showSalary() {
        System.out.println("HiringManger salary: " + salary);
    }
}

public class Mock_Quiz2_1 {
    public static void main(String args[]) {
        ArrayList<Mock_Quiz2_3_Employee> emp = new ArrayList<>();
        emp.add(new Manager(55000.0));
        emp.add(new HiringManager(40000.0));
        for (Mock_Quiz2_3_Employee e : emp) {
            e.showSalary();
        }
    }
}