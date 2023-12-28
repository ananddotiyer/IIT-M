import java.util.*;
import java.util.stream.*;

class GPA1_Employee{
    private String name;
    private String dept;
    private int salary;
    public GPA1_Employee(String n, String d, int s) {
        name = n;
        dept = d;
        salary = s;
    }
    public String get_name() {
        return name;
    }
    public String get_dept() {
        return dept;
    }
    public int get_salary() {
        return salary;
    }
    public String toString() {
        return name + " : " + dept + " : " + salary;
    }
}

class GPA1{
    public static Stream<GPA1_Employee> query(
            List<GPA1_Employee> eList, String d, double s){
        Stream<GPA1_Employee> st = eList.stream()
            .filter(n -> (n.get_dept().equals(d) 
                && n.get_salary() >= s));
        return st;
    }
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var eList = new ArrayList<GPA1_Employee>();
        eList.add(new GPA1_Employee("Jack", "HR", 30000));
        eList.add(new GPA1_Employee("Aria", "HR", 40000));
        eList.add(new GPA1_Employee("Nora", "IT", 50000));
        eList.add(new GPA1_Employee("Bella", "IT", 60000));
        eList.add(new GPA1_Employee("Jacob", "IT", 70000));
        eList.add(new GPA1_Employee("James", "HR", 80000));
        String d = sc.next();       //read department
        double s = sc.nextInt();    //read salary
		
        var st = query(eList, d, s);
        st.forEach(n -> System.out.println(n + " "));
    }
}