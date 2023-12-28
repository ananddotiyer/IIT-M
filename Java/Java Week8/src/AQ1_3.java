class AQ1_3_Employee{
     int x;
     String str;
     AQ1_3_Employee(int x,String b){
          this.x=x;
          this.str=b;
      }
      public String toString(){
          return "ID: "+x+" Name: "+str;
      }
      public Object clone() throws CloneNotSupportedException{
          return super.clone();
      }
}
public class AQ1_3{
      public static void main(String[] args){
           try{
                AQ1_3_Employee obj=new AQ1_3_Employee(1,"Sun");
                System.out.println(obj);
                AQ1_3_Employee obj2=new AQ1_3_Employee(2,"Moon");
                System.out.println(obj2);
                AQ1_3_Employee obj3=(AQ1_3_Employee)obj.clone();
                obj3.x=3;
                System.out.println(obj);
           }
           catch(CloneNotSupportedException e){
                 System.out.println("No permission to clone");
           }
       }
}