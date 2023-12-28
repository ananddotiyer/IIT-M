import java.util.*;

class Quiz2_171_School implements Cloneable {
    String schoolName;
    String place;

    public Quiz2_171_School(String s, String p) {
        schoolName = s;
        place = p;
    }

    public Quiz2_171_School clone() throws CloneNotSupportedException {
        return (Quiz2_171_School) super.clone();
    }
}

class Quiz2_171_Student implements Cloneable {
    Quiz2_171_School sch;
    String stuName;

    public Quiz2_171_Student(String n, Quiz2_171_School s) {
        sch = s;
        stuName = n;
    }

    public Quiz2_171_Student clone() throws CloneNotSupportedException {
        Quiz2_171_Student s = (Quiz2_171_Student) super.clone();
        s.sch = s.sch.clone(); //Without this line, s1 would be Neeraj:DAV:Delhi
        return s;
    }

    public String toString() {
        return stuName + ":" + sch.schoolName + " : " + sch.place;
    }
}

public class Quiz2_171 {
    public static void main(String[] args) {
        Quiz2_171_Student s1 = new Quiz2_171_Student("Vasanth", 
            new Quiz2_171_School("DAV", "Chennai"));

        try {
            Quiz2_171_Student s2 = s1.clone();
            s2.stuName = "Neeraj";
            s2.sch.place = "Delhi";
            System.out.println(s1 + ", " + s2);
        } catch (CloneNotSupportedException e) {
            System.out.println(" Cloning not supported");
        }
    }
}
