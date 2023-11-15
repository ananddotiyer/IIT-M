class Demo00_Employee {
    Object x;
    public Demo00_Employee() {
        this.x = 2;
    }
}
class Demo00_Employee_Generic<T> {
    T x;
    public Demo00_Employee_Generic(T x) {
        this.x = x;
    }
}
class Demo00_Manager extends Demo00_Employee {
    public Demo00_Manager() {

    }
}
public class Demo00 {
    public static void main(String[] args) {
        Object mgr = new Demo00_Manager();    
        Demo00_Employee emp = new Demo00_Manager();
        System.out.println(emp.x);
        
        int x = (int)emp.x;
        System.out.println("Value of x in a normal Employee class is:" + x);

        Demo00_Employee_Generic<Integer> emp1 = new Demo00_Employee_Generic<Integer>(12);
        System.out.println("Value of x in a generic Employee class is: " + emp1.x);

        Demo00_Employee_Generic<String> emp2 = new Demo00_Employee_Generic<String>("Generic");
        System.out.println("Value of x in a generic Employee class is: " + emp2.x);

    }
    
    
}
