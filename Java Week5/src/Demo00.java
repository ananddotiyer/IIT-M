class Employee {
    Object x;
    public Employee() {
        this.x = 2;
    }
}
class Employee_Generic<T> {
    T x;
    public Employee_Generic(T x) {
        this.x = x;
    }
}
class Manager extends Employee {
    public Manager() {

    }
}
public class Demo00 {
    public static void main(String[] args) {
        Object mgr = new Manager();    
        Employee emp = new Manager();
        System.out.println(emp.x);
        
        int x = (int)emp.x;
        System.out.println("Value of x in a normal Employee class is:" + x);

        Employee_Generic<Integer> emp1 = new Employee_Generic<Integer>(12);
        System.out.println("Value of x in a generic Employee class is: " + emp1.x);

        Employee_Generic<String> emp2 = new Employee_Generic<String>("Generic");
        System.out.println("Value of x in a generic Employee class is: " + emp2.x);

    }
    
    
}
