public class AQ2_8_Example{
     public void display(int x){
          System.out.println("Sun");
     }
     public void display(int x,var str){
          System.out.println("Moon");
     }
}
public class AQ2_8{
     public static void main(String[] args){
           AQ2_8_Example obj=new AQ2_8_Example();
           obj.display(0,"Sun");
     }
}