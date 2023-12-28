        class Mock_Quiz2_4_Department implements Cloneable{
            String name;
            public Mock_Quiz2_4_Department(String n){
                name = n;
            }
            public Mock_Quiz2_4_Department clone() throws CloneNotSupportedException{
                return (Mock_Quiz2_4_Department)super.clone();
             }
          }
          class Mock_Quiz2_4_University implements Cloneable{
              Mock_Quiz2_4_Department dept;
              String Uname;
              public Mock_Quiz2_4_University(Mock_Quiz2_4_Department d, String n){
                   dept = d;
                   Uname = n;
              }
              public Mock_Quiz2_4_University clone() throws CloneNotSupportedException{
                Mock_Quiz2_4_University u = (Mock_Quiz2_4_University)super.clone();
                u.dept = dept.clone();
                return u;
              }
              public String toString(){
                  return Uname + ":" + dept.name;
              }
           }
           public class Mock_Quiz2_5 {
               public static void main(String[] args) {
                   Mock_Quiz2_4_University u1 = new Mock_Quiz2_4_University(new Mock_Quiz2_4_Department("cse"), "xyz");
                   try{
                      Mock_Quiz2_4_University u2 = u1.clone();
                      u2.dept.name = "ece";
                      System.out.println(u1 + ","+ u2);
                   }
                   catch(Exception e){
                      System.out.println(e);
                   }
              }
         }