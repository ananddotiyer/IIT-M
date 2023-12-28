//Demo for generics
import java.util.ArrayList;

class Unrelated{
    public double calculate_bonus() {
        return 100;
    }
}
class Abstract {
    public double calculate_bonus() {
        return 0;
    }
}

class Demo1_Employee extends Abstract {
    float salary;

    public Demo1_Employee(float salary) {
        // System.out.println("Inside EMployee constructor");
        this.salary = salary;
    }

    public double calculate_bonus() {
        return (this.salary * 1.2);
    }

}

class Demo1_Manager extends Demo1_Employee {
    public Demo1_Manager(float salary) {
        super(salary);
        // System.out.println("Inside Manager constructor");
    }

    public double calculate_bonus() {
        return (this.salary * 1.5);
    }
}

class SuperAdmin extends Demo1_Employee {
    public SuperAdmin(float salary) {
        super(salary);
        // System.out.println("Inside SuperAdmin constructor");
    }

    public double calculate_bonus() {
        return (this.salary * 2);
    }
}

public class Demo0 {
    public static void main(String[] args) {
        Abstract emp = new Demo1_Employee(100);
        Abstract mgr = new Demo1_Manager(100);
        Abstract admin = new SuperAdmin(100);

        //Non-generic
        // Abstract emps[] = new Abstract[5];

        // emps[0] = emp;
        // emps[1] = mgr;
        // emps[2] = admin;

        //Generic-Use an arrayList instead
        ArrayList<Abstract> emps = new ArrayList<>();
        emps.add(emp);
        emps.add(mgr);
        emps.add(admin);

        print_all_bonus(emps);
    }

    //Non-Generic
    // public static void print_all_bonus(Abstract[] emps) {
    //     for (Abstract emp : emps) {
    //         if (emp != null)
    //             print_bonus(emp);
    //     }
    // }
    
    //Generic
    public static void print_all_bonus(ArrayList<Abstract> emps) {
        for (Abstract emp : emps) {
            if (emp != null)
                print_bonus(emp);
        }
    }

    public static <T extends Abstract> void print_bonus(T emp) {
        System.out.println(emp.calculate_bonus());
    }
    // public static void print_bonus(Unrelated unrelated) {
    //     System.out.println(unrelated.calculate_bonus());
    // }

}
