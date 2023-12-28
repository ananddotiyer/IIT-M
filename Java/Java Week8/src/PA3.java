class PA3_Address implements Cloneable{
      private int houseno;
      private String city;
      public PA3_Address(int houseno, String city) {
          this.houseno = houseno;
          this.city = city;
      }
     public void updateAddress(int houseno, String city) {
         this.houseno = houseno;
         this.city = city;
     }
     public String toString() {
         return houseno + " : " + city;
     }
     public PA3_Address clone() throws CloneNotSupportedException{
         return (PA3_Address)super.clone();
     }
}

class PA3_Person implements Cloneable{
     private String name;
     private PA3_Address addr;
     public PA3_Person(String name, PA3_Address addr){
         this.name = name;
         this.addr = addr;
     }
     public PA3_Person clone() throws CloneNotSupportedException{
        PA3_Person newPer = (PA3_Person)super.clone();
        newPer.addr = addr.clone();
        return newPer;
     }
     public void updatePerson(String name, int houseno, String city) {
        this.name = name;
        addr.updateAddress(houseno, city);
     }
    public String toString() {
        return name + " : " + addr;
     }
}
public class PA3{
   public static void main(String[] args) {
       try {
             PA3_Person per1 = new PA3_Person("binit", new PA3_Address(100, "Delhi"));
             PA3_Person per2 = per1.clone();
             per1.updatePerson("rajiv", 200, "Kolkata");
             System.out.print(per1 + ", " + per2);
       }
      catch(CloneNotSupportedException e) {
            System.out.println("clone() not supported");
       }
    }
}