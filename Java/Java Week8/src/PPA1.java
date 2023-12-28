import java.util.*;
class Address implements Cloneable {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    protected Test_Address clone() throws CloneNotSupportedException {
        return (Test_Address) super.clone();
    }
}

class Department implements Cloneable {
    private String department;

    public Department(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    protected Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }
}

class Person implements Cloneable {
    private String name;
    private Test_Address addr;

    public Person(String name, Test_Address addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public Test_Address getAddr() {
        return addr;
    }

    public void  setAddr(Test_Address addr) {
        this.addr = addr;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.addr = addr.clone();
        return cloned;
    }
}

class Employee extends Person {
    private Department dept;

    public Employee(String name, Test_Address addr, Department dept) {
        super(name, addr);
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = new Department(dept);
    }

    public void updateEmp(String newAddr, String newDept) {
        setAddr(new Test_Address(newAddr));
        setDept(newDept);
    }

    @Override
    protected Test_Employee clone() throws CloneNotSupportedException {
        Test_Employee cloned = (Test_Employee) super.clone();
        cloned.dept = dept.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return getName() + " : " + getAddr().getAddress() + " : " + getDept().getDepartment();
    }
}


public class PPA1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next(); //read name
        String a1 = sc.next(); //read address
        String d1 = sc.next(); //read department
        String a2 = sc.next(); //read new address
        String d2 = sc.next(); //read new department
        try {
            Test_Employee e1 = new Test_Employee(n, new Test_Address(a1), new Department(d1));
            Test_Employee e2 = e1.clone(); 
            e1.updateEmp(a2, d2);
            System.out.println(e1 + ", " + e2);
        }
        catch(CloneNotSupportedException e) {
            System.out.println("clone() not supported");
        }
    }
}
