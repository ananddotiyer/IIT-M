// import java.util.*;

class Employee_PAQ20 {
    int eid;
    String ename;
    String eprojects[];

    public Employee_PAQ20(Employee_PAQ20 e) {
        this.eid = e.eid;
        this.ename = e.ename;
        this.eprojects = e.eprojects;
    }

    public Employee_PAQ20(int id, String name, String[] projects) {
        this.eid = id;
        this.ename = name;
        this.eprojects = projects;
    }

    public void display() {
        System.out.println("eid: " + eid);
        System.out.println("ename: " + ename);
        System.out.println("eprojetcs: ");
        for (String s : eprojects) {
            System.out.println(s);
        }
    }

    public void mutator() {
        this.ename = this.ename + "__IITM";
        this.eprojects[0] = "P6";
    }
}

public class PAQ20 {
    public static void main(String[] args) {

        String arr[] = { "P1", "P2" };
        Employee_PAQ20 e1 = new Employee_PAQ20(12, "Alex", arr);
        Employee_PAQ20 e2 = new Employee_PAQ20(e1);
        e1.mutator();
        e1.display();
        e2.display();
    }
}