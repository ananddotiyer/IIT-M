import java.util.*;
class GPA1_Person{
    private String name;
    private long aadharno;
    public GPA1_Person(String name, long aadharno){
        this.name = name;
        this.aadharno = aadharno;
    }
    public void print() {
        System.out.println("name : " + name);
        System.out.println("aadharno : " + aadharno);
    }
}

class GPA1_Employee extends GPA1_Person{
    private double salary;
    // Kunal
    // Bikash
    // 1011101
    // 1022010
    // 30000.00
    // 50
    // name : Kunal
    // aadharno : 1011101
    // salary : 30000.0
    // name : Bikash
    // aadharno : 1022010
    // salary : 5000.0

    public GPA1_Employee(String name, long aadhar, Double salary) {
        super(name, aadhar);
        this.salary = salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //override print method 
    public void print() {
        super.print();
        System.out.println("salary : " + this.salary);
    }
}

class ContactEmployee extends GPA1_Employee{
    final private static double hourlyPay = 100.00;
    private int contactHour;
	
    public ContactEmployee(String name, long aadhar, int contactHour) {
        super(name, aadhar, 0.0);
        this.contactHour = contactHour;
        super.setSalary(this.contactHour * hourlyPay);
    }
    //salary is computed as contactHour * hourlyPay  
}

public class GPA1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm1 = sc.nextLine();
        String nm2 = sc.nextLine();
        long adh1 = sc.nextLong();
        sc.nextLine();  // consume leftover newline
        long adh2 = sc.nextLong();
        sc.nextLine();  // consume leftover newline
        double sal = sc.nextDouble();
        sc.nextLine();  // consume leftover newline
        int cont = sc.nextInt();
        sc.nextLine();  // consume leftover newline
        GPA1_Employee[] eArr = new GPA1_Employee[2];
        eArr[0] = new GPA1_Employee(nm1, adh1, sal);
        eArr[1] = new ContactEmployee(nm2, adh2, cont);
        for(GPA1_Employee e : eArr)
            e.print();
    }
}