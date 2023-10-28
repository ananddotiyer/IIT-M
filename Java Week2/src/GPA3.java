import java.util.*;

class GPA3_Employee
{
    String eid;
    String ename;
    String eprojects[];
    //Define all the required methods here
    public GPA3_Employee(String id, String name, String[] project) {
        eid = id;
        ename = name;
        eprojects = project;
    }
    public GPA3_Employee(GPA3_Employee emp) {
        eid = emp.eid;
        ename = emp.ename;
        eprojects = new String[emp.eprojects.length];
        // System.out.println(eprojects.length);
        
        for (int i = 0; i < emp.eprojects.length; i++) {
            eprojects[i] = emp.eprojects[i];    
        }
        // eprojects = emp.eprojects;
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
        //Enter the id of employee
        String id = s.nextLine();
        //Enter the name of employee
        String name = s.nextLine();
        
        GPA3_Employee e1 = new GPA3_Employee(id,name,project);
        GPA3_Employee e2 = new GPA3_Employee(e1); 
        //The copy constructor must copy all the data members. 
       
        e1.mutator();
        
        e2.display();
    }
}