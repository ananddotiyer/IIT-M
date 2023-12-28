interface PA7_Verifiable{
       public abstract boolean isEqual(Object d);
}
class PA7_Employee implements PA7_Verifiable{
       private int id;
       private String name;
       public PA7_Employee(int id, String name) {
            this.id = id;
            this.name = name;
       }
       public int get_id() {
            return id;
       }
       public String get_name() {
            return name;
       }
       public boolean isEqual(Object d) {
            if(d instanceof PA7_Employee)
                 if(this.id == ((PA7_Employee)d).id)
                      return true;
            return false;
       }
}
class PA7_Manager extends PA7_Employee{
      private String department;
      public PA7_Manager(int id, String name, String department) {
            super(id, name);
            this.department = department;
      }
      public String get_department() {
            return department;
      }
}
public class PA7{
    public static <T extends PA7_Verifiable, S extends T> boolean findEmployee(T[] arr, S m)
//     public static <T, S extends PA7_Verifiable> boolean findEmployee(T[] arr, S m) //THis also works
     {
            for(int i = 0; i < arr.length; i++) {
                    if(m.isEqual(arr[i]))
                          return true;
            }
            return false;
     }


     public static void main(String[] args) {
            PA7_Employee[] emps = {new PA7_Employee(101, "Darpan"),
                       new PA7_Employee(102, "Aanya"), new PA7_Employee(103, "Binita"),
                       new PA7_Employee(104, "Jairaj"), new PA7_Employee(105, "Ishaan")};
            PA7_Manager m = new PA7_Manager(103, "Binita", "IT");
            System.out.println(findEmployee(emps, m));
      }
}