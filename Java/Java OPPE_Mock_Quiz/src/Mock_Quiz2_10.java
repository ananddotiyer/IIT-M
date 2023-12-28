        import java.lang.reflect.*;
        import java.util.ArrayList;
        class Mock_Quiz2_10_Student{
               public static final String college = "IITM"; //Line 1
               private String name;
               public int rollno;
               public Mock_Quiz2_10_Student() {}
               public Mock_Quiz2_10_Student(String name) {
                      this.name = name;
               }
               private Mock_Quiz2_10_Student(int rollno) { //Line 2
                     this.rollno = rollno;
               }
               public String getName() {
                      return name;
               }
               public int getRollno() {
                      return rollno;
               }
          }
          public class Mock_Quiz2_10{
                public static void main(String[] args) throws ClassNotFoundException {
                       ArrayList<String> list = new ArrayList<String>();
                       Class c = Class.forName("Mock_Quiz2_10_Student");
                       Constructor[] consts = c.getConstructors();
                       Field[] fields1 = c.getFields();
                       for(Constructor i:consts)
                             list.add(i.toString());
                       for(Field i : fields1)
                             list.add(i.toString());
                       for(String i:list)
                             System.out.println(i);
                }
          }