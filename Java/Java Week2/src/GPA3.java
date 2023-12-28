import java.util.*;

class GPA3_Employee
{
    String eid;
    String ename;
    String eprojects[];
    public GPA3_Employee(String id, String name, String[] project) {
        eid = id;
        ename = name;
        eprojects = project;
    }
    //Copy constructor
    public GPA3_Employee(GPA3_Employee emp) {
        eid = emp.eid;
        ename = emp.ename;
        eprojects = new String[emp.eprojects.length];
        
        for (int i = 0; i < emp.eprojects.length; i++) {
            eprojects[i] = emp.eprojects[i];    
        }
    }
    public void display() {
        System.out.println("id:" + eid);
        System.out.println("name:" + ename);
        System.out.println("projects:");
        for (String eproject : eprojects) {
            System.out.print(eproject + ":" );    
        }
    }
public void mutator()
    {
        this.ename = "Mr "+ this.ename;
        this.eprojects[0] = null;
    }
    
}
public class GPA3
{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
    	String project[] = {"P001","P002","P003"};
        String id = s.nextLine();
        String name = s.nextLine();
        
        GPA3_Employee e1 = new GPA3_Employee(id,name,project);
        GPA3_Employee e2 = new GPA3_Employee(e1); //Using copy constructor
       
        e1.mutator(); //Mutating the e1's first project.
        e1.display();
        e2.display(); //but, that doesn't affect e2 since e2's eprojects is a copy of e1.
    }
}