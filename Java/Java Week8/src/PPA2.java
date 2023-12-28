//This file has been modified a lot, refer to my answer in the portal
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// class StudentList{
//     public ArrayList<Student> getEligibleList(ArrayList<Student> fullList){
//     }
// }
class Student{
    String roll;
    Date vaccination_1;
    Date vaccination_2;
    public Student(String roll, String v1){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.roll = roll;
        try {
            this.vaccination_1 = sdf.parse(v1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Roll: " + roll + ", first vaccination on: " + sdf.format(vaccination_1);
    }
}

public class PPA2{
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Student> studentList = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        int num_students = sc.nextInt();
        for (int i = 0; i < num_students; i++){
            String roll = sc.next();
            String vacc1 = sc.next();
            studentList.add(new Student(roll, vacc1));
        }
        System.out.println(studentList);
        try{
            Date dt1 = sdf.parse("11/04/1973");
            Date dt2 = sdf.parse("11/04/1974");
            long milli_seconds = (dt1.getTime() - dt2.getTime()); 
            long num_days_elapsed = milli_seconds/(1000 * 60 * 60 * 24);
            System.out.println(num_days_elapsed);
        }
        catch (ParseException Ex){

        }
    }
    
}