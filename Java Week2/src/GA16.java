class Employee_GA16 {
    int eid;
    String ename;

    public void display() {
        System.out.println("eid: " + eid);
        System.out.println("ename: " + ename);
    }
}

public class GA16 {
    public static void main(String[] args) {
        Employee_GA16 e1 = new Employee_GA16(); //by default eid is 0, and ename is null.
        e1.display();
    }
}